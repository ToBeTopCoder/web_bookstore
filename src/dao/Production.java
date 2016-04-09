package dao;

/*
 * 商品类
 * @notice 商品名称在数据表中是唯一的
 */
public class Production {
	private int id;			 // not null
	private String name;	 // not null
	private double price;	 // not null
	private String category; // 商品分类
	private int pnum;		 // 商品剩余库存量
	private String imgurl;	 // 商品图片url
	private String description; // 商品描述
	
	public Production() {
		id = 0;
		name = "";
		price = 0.0;
		category = "";
		pnum = 0;
		imgurl = "";
		description = "";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescript(String description) {
		this.description = description;
	}
}
