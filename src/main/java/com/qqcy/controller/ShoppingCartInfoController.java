package com.qqcy.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qqcy.po.ShoppingCart;
import com.qqcy.po.ShoppingCartInfo;
import com.qqcy.po.User;
import com.qqcy.po.Vegetable;
import com.qqcy.service.ShoppingCartInfoService;
import com.qqcy.service.ShoppingCartService;
import com.qqcy.service.VegetableService;
import com.qqcy.util.BaseController;

/**
 * 购物车信息控制器层
 * @author 张帅哥
 *
 */
@Controller
@RequestMapping("/shoppingcartinfo/")
public class ShoppingCartInfoController extends BaseController{

	@Autowired
	private ShoppingCartInfoService shoppingCartInfoService;
	
	@Autowired
	private VegetableService vegetableService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	private static final List<Integer> v_idlist = new ArrayList<Integer>();
	
	
	@RequestMapping("add.do")
	public String addCartInfo(ShoppingCartInfo shoppingCartInfo, HttpServletRequest request, Model model){//传来vegetable的id

		
//		Integer v_id = request.getParameter("");
		Integer v_id = 3;
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(v_id);
		HttpSession session = request.getSession();
//		Integer u_id = session.getAttribute("");
		Integer u_id = 1;
		User user = new User();
		user.setU_id(u_id);
		shoppingCartInfo.setVegetable(vegetable);
		shoppingCartInfo.setUser(user);
		for (Integer v_idlist : v_idlist) {
			if(v_idlist == v_id){
				System.out.println("找到重复的v_id");
				vegetable.setV_id(v_idlist);
				shoppingCartInfo.setVegetable(vegetable);
				return updateCartInfoVege_numOutCart(shoppingCartInfo, request);
			}
		}System.out.println("没有找到重复的v_id");
//		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoService.getCartInfoList(shoppingCartInfo);
//		for (ShoppingCartInfo info : shoppingCartInfos) {
//				Integer id = info.getVegetable().getV_id();
//				if(id == v_id){
//					incrementVege_num(shoppingCartInfo);
//				}
//		}
		
		shoppingCartInfoService.addCartInfo(shoppingCartInfo);
		System.out.println("添加蔬菜到购物车成功");
		v_idlist.add(v_id);
		getCartInfoList(vegetable, shoppingCartInfo, request, model);
		return "BuyStore";
	}
	
	@RequestMapping("add1.do")
	public String add1CartInfo(ShoppingCartInfo shoppingCartInfo, HttpServletRequest request, Model model){
		Integer v_id = Integer.parseInt(request.getParameter("v_id"));
		User user = (User) request.getSession().getAttribute("user"); 
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(v_id);
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setVegetable(vegetable);
		for (Integer v_idlist : v_idlist) {
			if(v_idlist == v_id){
				System.out.println("找到重复的v_id");
				vegetable.setV_id(v_idlist);
				shoppingCartInfo.setVegetable(vegetable);
				return updateCartInfoVege_numOutCart(shoppingCartInfo, request);
			}
		}
		System.out.println("没有找到重复的v_id");
		shoppingCartInfoService.addCartInfo(shoppingCartInfo);
		System.out.println("添加蔬菜到购物车成功");
		v_idlist.add(v_id);
		getCartInfoList(vegetable, shoppingCartInfo, request, model);
		return "BuyStore";
	}
	
	@RequestMapping("list.do")
	public String getCartInfoList(Vegetable vegetable, ShoppingCartInfo shoppingCartInfo, HttpServletRequest request, Model model){
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setVegetable(vegetable);
		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoService.getCartInfoList(shoppingCartInfo);
		for (ShoppingCartInfo info : shoppingCartInfos) {
			v_idlist.add(info.getVegetable().getV_id());
			System.out.println("正在配置和v_idlist...");
		}
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		ShoppingCart shoppingCart1 = shoppingCartService.getShoppingCart(shoppingCart);
		model.addAttribute("shoppingCartInfos", shoppingCartInfos);
		model.addAttribute("shoppingCart", shoppingCart1);
		return "BuyStore";
		
	}
	
	@RequestMapping("conditionslist.do")
	public String getCartInfoListInConditions(Vegetable vegetable, ShoppingCartInfo shoppingCartInfo, Model model, HttpServletRequest request){
		System.out.println(vegetable.getV_name());
		User user = (User) request.getSession().getAttribute("user");
		shoppingCartInfo.setUser(user);
		if(vegetable.getV_name() != null && !vegetable.getV_name().equals("")){
			shoppingCartInfo.setVegetable(vegetable);
			List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoService.getCartInfoListInConditions(shoppingCartInfo);
			ShoppingCart shoppingCart = new ShoppingCart();
			shoppingCart.setUser(user);
			ShoppingCart shoppingCart1 = shoppingCartService.getShoppingCart(shoppingCart);
			model.addAttribute("shoppingCartInfos", shoppingCartInfos);
			model.addAttribute("shoppingCart", shoppingCart1);
			return "BuyStore";
		}
		return getCartInfoList(vegetable, shoppingCartInfo, request, model);
	}
	/**
	 * 购物车内的更新蔬菜数量，具体用在前端数量文本框的失焦，得到的数量是一个蔬菜的总数量
	 * 利用ajax技术
	 * @param shoppingCartInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("updateVege_numInCart.do")
	public @ResponseBody String updateCartInfoVege_numInCart(ShoppingCartInfo shoppingCartInfo, HttpServletRequest request){
		//ajax
		//从前端获取蔬菜id与蔬菜总数量和用户id保存到shoppingCartInfo
		//判断蔬菜总数量是否大于200
		System.out.println(Integer.parseInt(request.getParameter("v_id")));
		Integer v_id = Integer.parseInt(request.getParameter("v_id"));
		Double sh_sumprice = Double.parseDouble(request.getParameter("finalprice"));
		System.out.println(sh_sumprice);
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setSh_sumprice(sh_sumprice);
		shoppingCartService.updateCart(shoppingCart);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(v_id);
		User user = (User) request.getSession().getAttribute("user");
		shoppingCartInfo.setVegetable(vegetable);
		shoppingCartInfo.setUser(user);
		Vegetable pvegetable = vegetableService.getVegetableNumById(shoppingCartInfo.getVegetable().getV_id());
		if(shoppingCartInfo.getShi_vegenum() <= pvegetable.getV_num()){
			shoppingCartInfoService.updateCartInfoVege_numInCart(shoppingCartInfo);
			System.out.println("1111");
			return "输入值在库存范围内！";
		}else{
			return "输入值大于库存！";
		}
	}
	
	/**
	 * 购物车外的更新蔬菜数量，在addCartInfo里被调用，得到的数量是在总数量的基础上增加的数量
	 * @param shoppingCartInfo
	 * @param request
	 * @return
	 */
	@RequestMapping("updateVege_numOutCart.do")
	public String updateCartInfoVege_numOutCart(ShoppingCartInfo shoppingCartInfo, HttpServletRequest request){
		//从前端获取蔬菜id(session)与蔬菜数量和用户id(session)保存到shoppingCartInfo
		User user = (User) request.getSession().getAttribute("user");
		Vegetable vegetable = new Vegetable();
		HttpSession session = request.getSession();
//		Integer v_id = (Integer) session.getAttribute("");
//		shoppingCartInfo.setUser(user);
//		shoppingCartInfo.setVegetable(vegetable);
		System.out.println("v_id = " + shoppingCartInfo.getVegetable().getV_id());
//		vegetable.setV_id(v_id);
		Double extralNum;
		if(request.getParameter("buyNum") == null){
			extralNum = 0.5;
		}else {
			extralNum = Double.parseDouble(request.getParameter("buyNum"));
		}
		System.out.println(shoppingCartInfo.getUser().getU_id());
		System.out.println(shoppingCartInfo.getVegetable().getV_id());
		ShoppingCartInfo shoppingCartInfo2 = shoppingCartInfoService.getCartInfoByV_id(shoppingCartInfo);//根据u_id,v_id两个条件查出单条记录
		Double previousNum = shoppingCartInfo2.getShi_vegenum();
		Double SumNum = previousNum + extralNum;
		shoppingCartInfo.setShi_vegenum(SumNum);
		shoppingCartInfoService.updateCartInfoVege_numOutCart(shoppingCartInfo);
		return "AddCartInfoSuccess";
	}
	
	@RequestMapping("decrement_num.do")
	public String decrementVege_num(ShoppingCartInfo shoppingCartInfo){
		//从前端获取用户id与用户id保存到shoppingcartInfo
		
		
		shoppingCartInfoService.decrementVege_num(shoppingCartInfo);
		return null;
	}
	
	@RequestMapping("increment.do")
	public String incrementVege_num(ShoppingCartInfo shoppingCartInfo){
		//从前端获取用户id与用户id保存到shoppingcartInfo
		
		
		shoppingCartInfoService.incrementVege_num(shoppingCartInfo);
		return null;
	}
	
	@RequestMapping("updateShi_status.do")
	public @ResponseBody String updateCartInfoShi_status(ShoppingCartInfo shoppingCartInfo, HttpServletRequest request){
		//从前端获取蔬菜id与用户id保存到shoppingCartInfo
		System.out.println(Integer.parseInt(request.getParameter("v_id")));
		Integer v_id = Integer.parseInt(request.getParameter("v_id"));
		
		Double sh_sumprice = Double.parseDouble(request.getParameter("finalprice"));
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setSh_sumprice(sh_sumprice);
		shoppingCartService.updateCart(shoppingCart);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(v_id);
		User user = (User) request.getSession().getAttribute("user");
		shoppingCartInfo.setVegetable(vegetable);
		shoppingCartInfo.setUser(user);
		ShoppingCartInfo shoppingCartInfo2 = shoppingCartInfoService.getCartInfoByV_id(shoppingCartInfo);
		System.out.println(shoppingCartInfo2.getUser().getU_id()+" "+shoppingCartInfo2.getVegetable().getV_id());
		shoppingCartInfoService.updateCartInfoShi_status(shoppingCartInfo2);
		return "xxxxxxxxxxxxxxxxxxxxxxs";
	}
	
	@RequestMapping("delete.do")
	public String deleteCartInfo(ShoppingCartInfo shoppingCartInfo, HttpServletRequest request, Model model){
		//从前端获取蔬菜id与用户id保存到shoppingCartInfo
		User user = (User) request.getSession().getAttribute("user");
		Vegetable vegetable = new Vegetable();
		Integer v_id = Integer.parseInt(request.getParameter("v_id"));
		System.out.println(v_id);
		vegetable.setV_id(v_id);
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setVegetable(vegetable);
		ShoppingCartInfo shoppingCartInfo2 = shoppingCartInfoService.getCartInfoByV_id(shoppingCartInfo);
		shoppingCartInfo2 = shoppingCartInfoService.getCartInfo(shoppingCartInfo2);
		Double Shi_vegenum = shoppingCartInfo2.getShi_vegenum();
		Double V_price = shoppingCartInfo2.getVegetable().getV_price();
		Double sumprice1 = Shi_vegenum*V_price;
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		ShoppingCart shoppingCart2 = shoppingCartService.getShoppingCart(shoppingCart);
		Double sumprice2 = shoppingCart2.getSh_sumprice();
		shoppingCart.setSh_sumprice(sumprice2-sumprice1);
		shoppingCartService.updateCart(shoppingCart);
		shoppingCartInfoService.deleteCartInfo(shoppingCartInfo);
		getCartInfoList(vegetable, shoppingCartInfo, request, model);
		return "BuyStore";
	}
	
	
}
