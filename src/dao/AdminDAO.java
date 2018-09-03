package dao;

import java.util.List;

import pojo.Admin;


/**
 * 关于Admin实体类的相关操作
 * @author leishao
 *
 */
public interface AdminDAO {
	/*
	 * 查询所有数据的方法
	 */
	List<Admin> findAll();
	
	/**
	 * 添加
	 */
	void add(Admin admin);
	/*
	 * 删除
	 */
	void delete(Integer id);
	
	void delete(String username);
	/*
	 * 修改
	 */
	void update(Admin admin);
	
	/*
	 * 根据id查询
	 */
	Admin findById(Integer id);

}
