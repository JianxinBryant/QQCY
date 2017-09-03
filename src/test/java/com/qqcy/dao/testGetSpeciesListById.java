package com.qqcy.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.Species;
import com.qqcy.po.Vegetable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class testGetSpeciesListById {
	@Autowired
	private SpeciesDao speciesDao;
	@Test
	 public void getSpeciesListByIdTest(){
		Species s=new Species();
		s.setSp_id(1);
		Species species=speciesDao.getSpeciesListById(s.getSp_id());
		System.out.println(species.getSp_name());
		System.out.println();
	 }

}
