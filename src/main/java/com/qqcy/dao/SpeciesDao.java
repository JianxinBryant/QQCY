package com.qqcy.dao;

import java.util.List;

import com.qqcy.po.Species;

/**
 * 蔬菜的种类接口
 * @author Administrator
 *
 */
public interface SpeciesDao {
	/**
	 * 查询种类的所有信息
	 * @param species
	 * @return
	 */
	public List<Species> getSpeciesList();
	/**
	 * 根据id查询种类的信息
	 * @param id
	 * @return
	 */
	public Species getSpeciesListById(Integer id);

}
