package com.qqcy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qqcy.dao.ManagerDao;
import com.qqcy.po.Manager;
import com.qqcy.service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDao managerDao;

	public boolean login(Manager manager) {
		Manager m = managerDao.find(manager);
		if(m != null){
			if(m.getM_password().equals(manager.getM_password())){
				return true;
			}
		}
		return false;
	}

}
