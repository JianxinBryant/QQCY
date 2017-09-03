package com.qqcy.service;

import java.util.List;

import com.qqcy.po.Species;

/**
 * 蔬菜种类的业务接口
 * @author Administrator
 *
 */
public interface SpeciesService {
	/**
	 * 得到种类的所有信息
	 * @param species
	 * @return
	 */
	public List<Species> getSpeciesList();

	

}
