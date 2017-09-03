package com.qqcy.dao;

import java.util.List;

import com.qqcy.po.Vegetable;

/**
 * 蔬菜信息的数据访问接口
 * @author Administrator
 *
 */

public interface VegetableDao {
	/**
	 * 添加蔬菜信息
	 * insert into...
	 * @param vegetable
	 */
	public void addVegetable(Vegetable vegetable);
	/**
	 * 删除蔬菜信息
	 * @param vegetable
	 */
	public void deleteVegetable(Vegetable vegetable);
	/**
	 * 根据条件/分页查询所有蔬菜信息
	 * @param vegetable查询条件
	 * @return
	 */
	public List<Vegetable> getVegetableList(Vegetable vegetable);
	/**
	 * 根据条件查询所有蔬菜记录数
	 * @param vegetable
	 * @return
	 */
	public long getCount(Vegetable vegetable);
	/**
	 * 更新蔬菜信息
	 * @param student
	 */
	public void updateVegetable(Vegetable vegetable);
	
	/**
	 * 根据条件加载蔬菜记录
	 * @param vegetable vegetable.id=?
	 * @return
	 */
	public Vegetable getVegetable(Vegetable vegetable);
	
	
	/**
	 * 根据Id查询蔬菜数量
	 * @param id
	 * @return
	 */
	public Vegetable getVegetableNumById(Integer id);
	
	/**
	 * 根据Id查询蔬菜
	 * @param id
	 * @return
	 */
	public Vegetable getVegetableById(Integer id);
}