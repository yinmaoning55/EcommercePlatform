package dao;

import java.util.List;

import pojo.Product;

public interface ProductDAO {
	List <Product>findAll();
	void add(Product p);
	Product findById(Integer id );
	void  updata (Product p);
	void  delete(Integer id);

}
