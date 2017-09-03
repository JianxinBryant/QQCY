package com.qqcy.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qqcy.dao.UserDao;
import com.qqcy.po.User;
import com.qqcy.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	

	public void registerUser(User user) {
		userDao.add(user);
	}

	public boolean loginUser(User user) {
		User u = userDao.find(user);
		if(u != null){
			if(u.getU_password().equals(user.getU_password())){
				return true;
			}
		}
		return false;
	}

	public boolean registerValidate(User user) {
		User u=userDao.find(user);
		if(u==null){
			return true;
		}
		return false;
	}


}

