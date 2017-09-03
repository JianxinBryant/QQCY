package com.qqcy.service;

import java.util.List;

import com.qqcy.po.Order;
import com.qqcy.po.ShoppingCartInfo;
import com.qqcy.po.User;

public interface OrderService {

	public List<Order> getOrderList(User user);
	
	public boolean finishOrder(Order order);
	
	public void createOrder(User user);
	
	public void cancelOrder(Order order);
}
