package dao;

import java.util.List;

import pojo.Admin;


/**
 * ����Adminʵ�������ز���
 * @author leishao
 *
 */
public interface AdminDAO {
	/*
	 * ��ѯ�������ݵķ���
	 */
	List<Admin> findAll();
	
	/**
	 * ���
	 */
	void add(Admin admin);
	/*
	 * ɾ��
	 */
	void delete(Integer id);
	
	void delete(String username);
	/*
	 * �޸�
	 */
	void update(Admin admin);
	
	/*
	 * ����id��ѯ
	 */
	Admin findById(Integer id);

}
