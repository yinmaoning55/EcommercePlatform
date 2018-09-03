package dao;

import java.util.List;

import pojo.User;

/**
 * 关于User实体类的相关操作
 * @author 
 *
 */
public interface UserDAO {
	/*
	 * 查询所有数据的方法
	 */
	List<User> findAll();
	
	/**
	 * 添加
	 */
	void add(User user);
	/*
	 * 删除
	 */
	void delete(Integer id);
	
	void delete(String username);
	/*
	 * 修改
	 */
	void update(User usr);
	
	/*
	 * 根据id查询
	 */
	User findById(Integer id);

	User findByUsername(String username);

}
