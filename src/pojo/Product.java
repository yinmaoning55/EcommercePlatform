package pojo;

import java.sql.Timestamp;

public class Product {
	private Integer id;
	private String name;
	private String descr;
	private double normalprice;
	private double memberprice;
	private Timestamp pdata;


	private Category category;


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descr=" + descr + ", normalprice=" + normalprice
				+ ", memberprice=" + memberprice + ", pdata=" + pdata + ", category=" + category + "]";
	}


	public Product(Integer id, String name, String descr, double normalprice, double memberprice, Timestamp pdata,
			Category category) {
		super();
		
		this.name = name;
		this.descr = descr;
		this.normalprice = normalprice;
		this.memberprice = memberprice;
		
		this.category = category;
	}


	public Product() {
		super();
	}
	public Product(String name, String descr, double normalprice, Timestamp pdata,
			Category category) {
		super();
		this.name = name;
		this.descr = descr;
		this.normalprice = normalprice;
		this.memberprice = normalprice*0.8;
		this.pdata = null;
		this.category = category;
	}

//	public Product(String name, String descr, double normalprice, double memberprice, Timestamp pdata,
//			Category category) {
//		super();
//		this.name = name;
//		this.descr = descr;
//		this.normalprice = normalprice;
//		this.memberprice = memberprice;
//		this.pdata = pdata;
//		this.category = category;
//	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((descr == null) ? 0 : descr.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(memberprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		temp = Double.doubleToLongBits(normalprice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((pdata == null) ? 0 : pdata.hashCode());
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
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (descr == null) {
			if (other.descr != null)
				return false;
		} else if (!descr.equals(other.descr))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(memberprice) != Double.doubleToLongBits(other.memberprice))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(normalprice) != Double.doubleToLongBits(other.normalprice))
			return false;
		if (pdata == null) {
			if (other.pdata != null)
				return false;
		} else if (!pdata.equals(other.pdata))
			return false;
		return true;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescr() {
		return descr;
	}


	public void setDescr(String descr) {
		this.descr = descr;
	}


	public double getNormalprice() {
		return normalprice;
	}


	public void setNormalprice(double normalprice) {
		this.normalprice = normalprice;
	}


	public double getMemberprice() {
		return memberprice;
	}


	public void setMemberprice(double memberprice) {
		this.memberprice = memberprice;
	}


	public Timestamp getPdata() {
		return pdata;
	}


	public void setPdata(Timestamp pdata) {
		this.pdata = pdata;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}
	
			

}
