package dao;

/*
 * 订单中条目类 对应表orderitem，具体查看db.sql文件
 * @author: luoxn28
 * @date: 2016.5.18
 */
public class OrderItem {
	private int orderId;
	private int productId;
	private int buyNum;
	
	public OrderItem() {
		this.orderId = 0;
		this.productId = 0;
		this.buyNum = 0;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
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
