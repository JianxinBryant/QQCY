package com.qqcy.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.Order;
import com.qqcy.po.OrderInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class OrderInfoDaoTest {
	@Autowired
	private OrderInfoDao orderInfoDao;
	
	@Test
	public void testGetOrderInfoList(){
		Order order = new Order();
		order.setO_id(1);
		List<OrderInfo> orderInfo = orderInfoDao.getOrderInfoList(order);
		for (OrderInfo orderInfo2 : orderInfo) {
			System.out.println(orderInfo2.getOi_vegenum()+"....");
		}
	}
}
