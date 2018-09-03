package pojo;

public class Img {
	private int id;
	private String descr;
	@Override
	public String toString() {
		return "Img [id=" + id + ", descr=" + descr + ", img=" + img + "]";
	}
	
	
		public Img( String descr, String img) {
			super();
			
			this.descr = descr;
			
			this.img = img;
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	private String img;
	

}
