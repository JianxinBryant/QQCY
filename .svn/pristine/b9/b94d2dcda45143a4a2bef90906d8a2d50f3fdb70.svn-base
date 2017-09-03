package com.qqcy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qqcy.dao.ShoppingCartDao;
import com.qqcy.po.ShoppingCart;
import com.qqcy.service.ShoppingCartService;

/**
 * 购物车服务层实现类
 * @author 张帅哥
 *
 */
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ShoppingCartDao shoppingCartDao;
	
	public void addCart(ShoppingCart shoppingCart) {
		
		shoppingCartDao.addCart(shoppingCart);
	}

	public void updateCart(ShoppingCart shoppingCart) {
		
		shoppingCartDao.updateCart(shoppingCart);
		
	}

	public ShoppingCart getShoppingCart(ShoppingCart shoppingCart) {
		return shoppingCartDao.getShoppingCart(shoppingCart);
	}

	

}
