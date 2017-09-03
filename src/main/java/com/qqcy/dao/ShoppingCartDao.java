package com.qqcy.dao;

import com.qqcy.po.ShoppingCart;

public interface ShoppingCartDao {

	public void addCart(ShoppingCart shoppingCart);
	
	public void updateCart(ShoppingCart shoppingCart);
	
	public ShoppingCart getShoppingCart(ShoppingCart shoppingCart);
	
}
