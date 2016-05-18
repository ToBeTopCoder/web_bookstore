package dao;

/*
 * 订单中条目类 对应表orderitem，具体查看db.sql文件
 * @author: luoxn28
 * @date: 2016.5.18
 */
public class OrderItem {
	private String orderId;
	private int productId;
	private int buyNum;
	
	public OrderItem() {
		this.orderId = "";
		this.productId = 0;
		this.buyNum = 0;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getBuyNum() {
		return buyNum;
	}
	
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
}
