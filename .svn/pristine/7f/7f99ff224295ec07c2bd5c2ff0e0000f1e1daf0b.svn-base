package com.qqcy.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.ShoppingCartInfo;
import com.qqcy.po.User;
import com.qqcy.po.Vegetable;

/**
 * 购物车信息Dao层测试类
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class ShoppingCartInfoDaoTest {

	@Autowired
	private ShoppingCartInfoDao shoppingCartInfoDao;
	@Test
	public void testAddVegetable(){
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		shoppingCartInfo.setShi_id(1);
		shoppingCartInfo.setShi_status("true");
		shoppingCartInfo.setShi_vegenum(2.2);
		User user = new User();
		user.setU_id(1);
		shoppingCartInfo.setUser(user);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(1);
		shoppingCartInfo.setVegetable(vegetable);
		shoppingCartInfoDao.addCartInfo(shoppingCartInfo);
	}
	
	
	@Test
	public void testGetCartInfoList(){
		User user = new User();
		user.setU_id(1);
		Vegetable vegetable = new Vegetable(); 
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setVegetable(vegetable);
		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoDao.getCartInfoList(shoppingCartInfo);
		for (ShoppingCartInfo info : shoppingCartInfos) {
			
			System.out.println("info.getShi_id() = " + info.getShi_id());
			System.out.println("info.getShi_vegenum() = " + info.getShi_vegenum());
			System.out.println("getU_id()) = " + info.getShi_status());
			System.out.println("info.getUser().getU_id() = " + info.getUser().getU_id());
			System.out.println("info.getVegetable().getV_id() = " + info.getVegetable().getV_id());
			System.out.println("-------------------");
		}
	}
	
	@Test
	public void testGetCartInfoByV_id(){
//		User user = new User();
//		user.setU_id(1);
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
//		shoppingCartInfo.setUser(user);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(1);
		shoppingCartInfo.setVegetable(vegetable);
		ShoppingCartInfo info = shoppingCartInfoDao.getCartInfoByV_id(shoppingCartInfo);
			
		System.out.println("info.getShi_id() = " + info.getShi_id());
		System.out.println("info.getShi_vegenum() = " + info.getShi_vegenum());
		System.out.println("getU_id()) = " + info.getShi_status());
		System.out.println("info.getUser().getU_id() = " + info.getUser().getU_id());
		System.out.println("info.getVegetable().getV_id() = " + info.getVegetable().getV_id());
	}
	
	@Test
	public void testUpdateCartInfoVege_num(){
		User user = new User();
		user.setU_id(1);
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(1);
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setVegetable(vegetable);
		shoppingCartInfo.setShi_vegenum(119);
		shoppingCartInfoDao.updateCartInfoVege_num(shoppingCartInfo);
		System.out.println("info.getShi_id() = " + shoppingCartInfo.getShi_id());
		System.out.println("info.getShi_vegenum() = " + shoppingCartInfo.getShi_vegenum());
		System.out.println("getU_id()) = " + shoppingCartInfo.getShi_status());
		System.out.println("info.getUser().getU_id() = " + shoppingCartInfo.getUser().getU_id());
		System.out.println("info.getVegetable().getV_id() = " + shoppingCartInfo.getVegetable().getV_id());
	}
	
	@Test
	public void testUpdateCartInfoShi_status(){
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		User user = new User();
		user.setU_id(1);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(1);
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setVegetable(vegetable);
		shoppingCartInfo.setShi_status("false");
		shoppingCartInfoDao.updateCartInfoShi_status(shoppingCartInfo);
		System.out.println("info.getShi_id() = " + shoppingCartInfo.getShi_id());
		System.out.println("info.getShi_vegenum() = " + shoppingCartInfo.getShi_vegenum());
		System.out.println("getShi_status() = " + shoppingCartInfo.getShi_status());
		System.out.println("info.getUser().getU_id() = " + shoppingCartInfo.getUser().getU_id());
		System.out.println("info.getVegetable().getV_id() = " + shoppingCartInfo.getVegetable().getV_id());
	}
	
	@Test
	public void testDeleteCartInfo(){
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		User user = new User();
		user.setU_id(1);
		Vegetable vegetable = new Vegetable();
		vegetable.setV_id(2);
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setVegetable(vegetable);
		shoppingCartInfoDao.deleteCartInfo(shoppingCartInfo);
	}
	
	@Test
	public void testGetCartInfoListByStatus(){
		User user = new User();
		user.setU_id(1);
		ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
		shoppingCartInfo.setUser(user);
		shoppingCartInfo.setShi_status("true");
		List<ShoppingCartInfo> shoppingCartInfos = shoppingCartInfoDao.getCartInfoListByStatus(shoppingCartInfo);
		for (ShoppingCartInfo info : shoppingCartInfos) {
			
			System.out.println("info.getShi_id() = " + info.getShi_id());
			System.out.println("info.getShi_vegenum() = " + info.getShi_vegenum());
			System.out.println("getU_id()) = " + info.getShi_status());
			System.out.println("info.getUser().getU_id() = " + info.getUser().getU_id());
			System.out.println("info.getVegetable().getV_id() = " + info.getVegetable().getV_id());
			System.out.println("-------------");
		}
	}
}
