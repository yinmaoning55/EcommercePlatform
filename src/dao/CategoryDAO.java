package dao;

import java.sql.Connection;
import java.util.List;

import pojo.Category;



public interface CategoryDAO {
	List<Category> findToTree();
	
	//List<Category> findAll();
	
	//void add(Category c);
	
	void add(String name,String descr);
	
	void delete(Integer id,Integer pid );
	
	void update(Category c);
	
	Category findById(Integer id);


	
	

}
