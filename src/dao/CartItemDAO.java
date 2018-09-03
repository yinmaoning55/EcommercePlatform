package dao;

import java.util.List;


import pojo.CartItem;

public interface CartItemDAO {
	void add(CartItem ci);

	List<CartItem> findAll() ;
	void delete();
		
}
