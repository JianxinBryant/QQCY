package com.qqcy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.Order;
import com.qqcy.po.OrderInfo;
import com.qqcy.service.OrderInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class OrderInfoServiceTest {

	@Autowired
	private OrderInfoService orderInfoService;
	
	
	@Test
	public void testGetOrderInfo(){
		Order order = new Order();
		order.setO_id(1);
		
		List<Order> orders = new ArrayList<Order>();
		orders.add(order);
		
		Map<Order, List<OrderInfo>> map = orderInfoService.getOrderInfoList(orders);
		
		System.out.println(map.size());
		
		for(Entry<Order, List<OrderInfo>> entry : map.entrySet()){
			int i = 0;
			for (OrderInfo orderInfo : entry.getValue()) {
				System.out.println("订单号："+entry.getKey().getO_sumprice()+"，商品id："+entry.getValue().get(i).getVegetable().getV_id()+"，商品名称和数量："+entry.getValue().get(i).getVegetable().getV_name()+"，"+entry.getValue().get(i).getOi_vegenum());
				i++;
			}
			
		}
	}
	
	@Test
	public void testTime(){
		System.out.println(new Date().getTime());
	}
}
