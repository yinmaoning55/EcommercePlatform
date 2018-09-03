package dao;

import java.util.List;

import pojo.User;

/**
 * ����Userʵ�������ز���
 * @author 
 *
 */
public interface UserDAO {
	/*
	 * ��ѯ�������ݵķ���
	 */
	List<User> findAll();
	
	/**
	 * ���
	 */
	void add(User user);
	/*
	 * ɾ��
	 */
	void delete(Integer id);
	
	void delete(String username);
	/*
	 * �޸�
	 */
	void update(User usr);
	
	/*
	 * ����id��ѯ
	 */
	User findById(Integer id);

	User findByUsername(String username);

}
