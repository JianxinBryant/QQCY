package com.qqcy.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.Species;


/**
 * 对SpeciesDao进行单元测试
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class SpeciesDaoTest {
	
	@Autowired
	private SpeciesDao speciesDao;
	@Test
	public void testGetSpeciesList(){
		Species species=new Species();
		species.setStart(0);
		
		List<Species> speciess = speciesDao.getSpeciesList();
		for (Species s : speciess) {
			System.out.println(s.getSp_name());
		}
	}
}
