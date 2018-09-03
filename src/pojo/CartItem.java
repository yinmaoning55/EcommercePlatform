package pojo;
/**
 * 购物车购物项
 * @author msi-pc
 *
 */

public class CartItem {
	private Integer id;
	private Product product;
	private Integer pcount;
	
	private Integer orderid;
	private Integer unitprice;
	public CartItem() {
		
	}
	
	
	@Override
	public String toString() {
		return "CartItem [id=" + id + ", product=" + product + ", pcount=" + pcount + ", orderid=" + orderid
				+ ", unitprice=" + unitprice + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((pcount == null) ? 0 : pcount.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((unitprice == null) ? 0 : unitprice.hashCode());
		return result;
	}
	
	
	
	@Override
	
	
	public boolean equals(Object obj) {
		CartItem i1=this;
		CartItem i2=(CartItem)obj;
		if(i1.getProduct().getId()==i2.getProduct().getId()) return true;
		else return false;
			
		
		
		
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Integer getPcount() {
		return pcount;
	}


	public void setPcount(Integer pcount) {
		this.pcount = pcount;
	}


	public Integer getOrderid() {
		return orderid;
	}


	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}


	public Integer getUnitprice() {
		return unitprice;
	}


	public void setUnitprice(Integer unitprice) {
		this.unitprice = unitprice;
	}


	public CartItem(Product product, Integer pcount, Integer orderid ,Integer unitprice) {
		super();
		this.product = product;
		this.pcount = pcount;
		this.orderid = orderid;
		this.unitprice=unitprice;
	}
	public CartItem(Integer id, Product product, Integer pcount, Integer orderid,Integer unitprice) {
		super();
		this.id = id;
		this.product = product;
		this.pcount = pcount;
		this.orderid = orderid;
		this.unitprice=unitprice;
	}

}
