package com.qqcy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.extra.spath.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qqcy.po.ShoppingCart;
import com.qqcy.po.User;
import com.qqcy.service.ShoppingCartService;
import com.qqcy.util.BaseController;
/**
 * 购物车控制器层
 * @author 张帅哥
 *
 */
@Controller
@RequestMapping("/shoppingcart/")
public class ShoppingCartController extends BaseController{

	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@RequestMapping("addCart.do")
	public String addCart(HttpServletRequest request,ShoppingCart shoppingCart){
		HttpSession session = request.getSession();
		Integer u_id = (Integer) session.getAttribute("");
		User user = new User();
		user.setU_id(u_id);
		shoppingCart.setUser(user);
		shoppingCart.setSh_sumprice(0);
		shoppingCartService.addCart(shoppingCart);
		return "";
		
	}
	
	
	
}
