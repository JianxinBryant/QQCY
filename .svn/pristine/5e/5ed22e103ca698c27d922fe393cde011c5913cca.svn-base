package com.qqcy.service;


import java.util.List;

import com.qqcy.po.ShoppingCartInfo;
/**
 * 购物车信息服务层接口
 * @author 张帅哥
 *
 */
public interface ShoppingCartInfoService {

	/**
	 * 添加蔬菜至购物车
	 * @param shoppingCartInfo 购物车信息类对象
	 * @param v_id 蔬菜编号
	 * @param u_id 用户编号
	 */
	public void addCartInfo(ShoppingCartInfo shoppingCartInfo);
	
	/**
	 * 得到某一用户的购物车信息表
	 * @return 购物车信息表list
	 */
	public List<ShoppingCartInfo> getCartInfoList(ShoppingCartInfo shoppingCartInfo);
	
	public ShoppingCartInfo getCartInfo(ShoppingCartInfo shoppingCartInfo);
	
	public List<ShoppingCartInfo> getCartInfoListInConditions(ShoppingCartInfo shoppingCartInfo);
	
	public ShoppingCartInfo getCartInfoByV_id(ShoppingCartInfo shoppingCartInfo);
	
	public void updateCartInfoVege_numInCart(ShoppingCartInfo shoppingCartInfo);
	
	public void updateCartInfoVege_numOutCart(ShoppingCartInfo shoppingCartInfo);
	
	public void updateCartInfoShi_status(ShoppingCartInfo shoppingCartInfo);
	
	public void deleteCartInfo(ShoppingCartInfo shoppingCartInfo);
	
	public void incrementVege_num(ShoppingCartInfo shoppingCartInfo);
	
	public void decrementVege_num(ShoppingCartInfo shoppingCartInfo);
	
}
