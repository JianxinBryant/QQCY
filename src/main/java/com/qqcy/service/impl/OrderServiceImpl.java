package com.qqcy.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qqcy.dao.OrderDao;
import com.qqcy.dao.OrderInfoDao;
import com.qqcy.dao.ShoppingCartDao;
import com.qqcy.dao.ShoppingCartInfoDao;
import com.qqcy.dao.VegetableDao;
import com.qqcy.po.Order;
import com.qqcy.po.OrderInfo;
import com.qqcy.po.ShoppingCart;
import com.qqcy.po.ShoppingCartInfo;
import com.qqcy.po.User;
import com.qqcy.po.Vegetable;
import com.qqcy.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private VegetableDao vegetableDao;
	
	@Autowired
	private ShoppingCartInfoDao shiDao;
	
	@Autowired
	private ShoppingCartDao shDao;

	public List<Order> getOrderList(User user) {
		List<Order> orders = orderDao.getOrderList(user);
		
		return orders;
	}

	public boolean finishOrder(Order order) {
		order = orderDao.getOrderStatusById(order);
		if(order.getO_status().equals("待付款") || order.getO_status().equals("待收货")){
			order.setO_status("已完成");
			orderDao.finishOrder(order);
			return true;
		}else{
			System.out.println("订单编号为："+order.getO_id()+"，状态不是待付款。。或者待收货。");
			return false;
		}
	}

	@Transactional
	public void createOrder(User user) {
		//初始化要创建的订单
		Order order = new Order();
		//设置创建订单时间
		order.setO_createtime(String.valueOf(new Date().getTime()));
		order.setO_status("待付款");
		order.setUser(user);
		//随机生成一个订单号
		order.setO_id(getRandNum());
		
		//初始化需要查找的购物车信息
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setShi_status("true");
		
		//查找所需的购物车信息
		List<ShoppingCartInfo> shis = shiDao.getCartInfoListByStatus(shoppingCartInfo);
		
		//初始化购物车
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		
		//从shopingcart表里取
		order.setO_sumprice(shDao.getShoppingCart(shoppingCart).getSh_sumprice());
		
		//插入订单
		orderDao.addOrder(order);
		
		for (ShoppingCartInfo shoppingcartInfo : shis) {
			//创建订单详细信息
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOi_vegenum(shoppingcartInfo.getShi_vegenum());
			orderInfo.setOrder(order);
			orderInfo.setVegetable(shoppingcartInfo.getVegetable());
			
			
			//修改蔬菜之前要将价格、数量信息查询出来并初始化
			Vegetable vege = vegetableDao.getVegetable(shoppingcartInfo.getVegetable());
			vege.setV_num(vege.getV_num() - shoppingcartInfo.getShi_vegenum());
			
			//修改蔬菜数量
			vegetableDao.updateVegetable(vege);
			
			//插入订单详细信息
			orderInfoDao.addOrderInfo(orderInfo);
		}
	}
	
	public int getRandNum(){
		Random r = new Random(System.currentTimeMillis());
		String str = String.valueOf(new Date().getTime()).substring(4);
		return Integer.parseInt(str)+r.nextInt(99999);
	}
	
	@Transactional
	public void cancelOrder(Order order){
		order = orderDao.getOrderStatusById(order);
		if(!order.getO_status().equals("待付款")){
			return;
		}
		try{
			List<OrderInfo> orderInfoList = orderInfoDao.getOrderInfoList(order);
			for (OrderInfo orderInfo : orderInfoList) {
				Vegetable vege = vegetableDao.getVegetable(orderInfo.getVegetable());
				vege.setV_num(vege.getV_num() + orderInfo.getOi_vegenum());
				vegetableDao.updateVegetable(vege);
			}
		
			//orderInfoDao.deleteOrderInfo(order);
			order.setO_status("关闭");
			orderDao.finishOrder(order);
		}catch(Exception e){
			throw new RuntimeException();
		}
		
	}

}
