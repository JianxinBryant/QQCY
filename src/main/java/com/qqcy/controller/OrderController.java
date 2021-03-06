﻿package com.qqcy.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qqcy.dao.OrderDao;
import com.qqcy.po.Order;
import com.qqcy.po.OrderInfo;
import com.qqcy.po.User;
import com.qqcy.service.OrderInfoService;
import com.qqcy.service.OrderService;

/**
 * 订单控制器
 * @author 张舰心
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderInfoService orderInfoService;
	
	@RequestMapping("/order.do")
	public String getOrderList(HttpServletRequest request,Model model){
		User user = (User) request.getSession().getAttribute("user");
		if(user == null){
			return "login";
		}
		
		List<Order> orders = orderService.getOrderList(user); 
		
		Map<Order, List<OrderInfo>> map = orderInfoService.getOrderInfoList(orders);
		
		
		model.addAttribute("orderInfoMap", map);
		return "order/myOrder";
	}
	
	@RequestMapping("/finish.do")
	public String finishOrder(Order order,HttpServletRequest request,Model model){
		orderService.finishOrder(order);
		return getOrderList(request, model);
	}
	
	
	@RequestMapping("/createOrder.do")
	public String createOrder(HttpServletRequest request,Model model){
		User user = (User) request.getSession().getAttribute("user");
		System.out.println("user:::"+user);
		if(user == null){
			return "login";
		}
		
		orderService.createOrder(user);
		return getOrderList(request, model);
	}
	
	@RequestMapping("/cancelOrder.do")
	public String cancel(HttpServletRequest request,Model model){
		
		if(request.getParameter("o_id") != null ){
			Order order = new Order();
			order.setO_id(Integer.parseInt(request.getParameter("o_id")));
			orderService.cancelOrder(order);
		}
		
		
		return getOrderList(request, model);
	}
}
