package com.qqcy.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.User;
import com.qqcy.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserServiceImplTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void test(){
		User user = new User();
		user.setU_username("xnn");
		user.setU_password("xnn");
		user.setU_truename("小宁宁");
		user.setU_telephone("13512345678");
		user.setU_sex("女");
		user.setU_email("xnn@qq.com");
		user.setU_createtime("123456789");
		user.setU_address("asdzxc");
		
		userService.registerUser(user);
	}
}
