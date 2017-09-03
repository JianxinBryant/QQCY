package com.qqcy.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.qqcy.po.Vegetable;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class VegetableDaoTest {

	@Autowired
	private VegetableDao vegetableDao;
	@Test
	public void testGetVegetableList(){
		Vegetable vegetable = new Vegetable();
		vegetable.setV_name("%绿色%");
		List<Vegetable> vegetables = vegetableDao.getVegetableList(vegetable);
		for (Vegetable v : vegetables) {
			System.out.println("v.getV_id = " + v.getV_id());
			System.out.println("v.getV_name = " + v.getV_name());
		}
	}
}
