package com.qqcy.po;

import com.qqcy.util.BaseBean;

public class OrderInfo extends BaseBean{
	private Integer oi_id;
	
	private double oi_vegenum;
	
	private Vegetable vegetable;
	
	private Order order;

	public Vegetable getVegetable() {
		return vegetable;
	}

	public void setVegetable(Vegetable vegetable) {
		this.vegetable = vegetable;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Integer getOi_id() {
		return oi_id;
	}

	public void setOi_id(Integer oi_id) {
		this.oi_id = oi_id;
	}

	public double getOi_vegenum() {
		return oi_vegenum;
	}

	public void setOi_vegenum(double oi_vegenum) {
		this.oi_vegenum = oi_vegenum;
	}
}
