package com.qqcy.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.Order;
import com.qqcy.po.User;
import com.qqcy.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class OrderServiceTest {
	
	@Autowired
	private OrderService orderService;
	
	
	@Test
	public void finishOrder(){
		Order order =new Order();
		order.setO_id(2);
		orderService.finishOrder(order);
	}
	
	@Test
	public void testAddOrder(){
		User user = new User();
		orderService.createOrder(user);
	}
}
