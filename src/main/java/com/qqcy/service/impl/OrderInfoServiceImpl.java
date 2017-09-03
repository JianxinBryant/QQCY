package com.qqcy.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qqcy.dao.OrderInfoDao;
import com.qqcy.dao.VegetableDao;
import com.qqcy.po.Order;
import com.qqcy.po.OrderInfo;
import com.qqcy.po.Vegetable;
import com.qqcy.service.OrderInfoService;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Autowired
	private VegetableDao vegeDao;

	public Map<Order, List<OrderInfo>> getOrderInfoList(List<Order> orders) {
		Map<Order, List<OrderInfo>> map = new LinkedHashMap <Order, List<OrderInfo>>();
		for (Order order : orders) {
			map.put(order, orderInfoDao.getOrderInfoList(order));
		}
		
		for(Entry<Order, List<OrderInfo>> entry : map.entrySet()){
			for (OrderInfo orderInfo : entry.getValue()) {
				Vegetable vegetable = vegeDao.getVegetable(orderInfo.getVegetable());
				orderInfo.setVegetable(vegetable);
			}
		}
		
		return map;
	}

}
