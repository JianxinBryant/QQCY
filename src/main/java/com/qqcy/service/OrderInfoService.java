package com.qqcy.service;

import java.util.List;
import java.util.Map;

import com.qqcy.po.Order;
import com.qqcy.po.OrderInfo;

public interface OrderInfoService {
	public Map<Order, List<OrderInfo>> getOrderInfoList(List<Order> orders);
}
