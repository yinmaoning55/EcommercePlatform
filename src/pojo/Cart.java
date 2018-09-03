package pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 购物车
 * @author msi-pc
 *
 */

public class Cart {
	private List<CartItem> items=new ArrayList<>();

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public Cart(List<CartItem> items) {
		super();
		this.items = items;
	}

	public Cart() {
		super();
	}
   
	public void add(CartItem CartItem){
		if(items.contains(CartItem)){
			for (CartItem i : items) {
				if(i.equals(CartItem)){
					i.setPcount(i.getPcount()+CartItem.getPcount());
				}
				
			}
		}else{
		
		
		items.add(CartItem);
	}
	}
	//增加购物项数量
	public void modify(Integer id, int pcount){
	for (CartItem cartItem : items) {
		if(id.equals(cartItem.getProduct().getId())){
			cartItem.setPcount(cartItem.getPcount()+pcount);
		}
		
	}
	}
	
	//删除购物项
	public void delete(Integer id){
		Iterator <CartItem> it=items.iterator();
		while(it.hasNext()){
			CartItem cartItem =it.next();
			if(id.equals(cartItem.getProduct().getId())){
				it.remove();
			}
		}
		
		
		
		
			
		}
		
		
		
}
	
