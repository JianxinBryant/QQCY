package com.qqcy.service;

import com.qqcy.po.ShoppingCart;
/**
 * 购物车服务层接口
 * @author 张帅哥
 *
 */

public interface ShoppingCartService {
	

	public void addCart(ShoppingCart shoppingCart);
	
	public void updateCart(ShoppingCart shoppingCart);
	
	public ShoppingCart getShoppingCart(ShoppingCart shoppingCart);
}
