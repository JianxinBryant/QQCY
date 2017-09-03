package com.qqcy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qqcy.dao.SpeciesDao;
import com.qqcy.po.Species;
import com.qqcy.service.SpeciesService;

/**
 * 蔬菜业务接口的实现类
 * @author Administrator
 *
 */
@Service
public class SpeciesServiceImpl implements SpeciesService{
	@Autowired
	private SpeciesDao speciesDao;

	public List<Species> getSpeciesList() {
		
		return speciesDao.getSpeciesList();
	}

	

}
