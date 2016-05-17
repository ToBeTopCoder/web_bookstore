package dao;

/*
 * 订单类 对应数据表orders，表结构可查看db.sql文件
 * @author: luoxn28
 * @date: 2016.5.18
 */
public class Order {
	private int id; 				// 订单id
	private double money; 			// 订单价格
	private String receiceAddress;	// 收货地址
	private String recviceName;		// 收货人
	private String recvicePhone;	// 收货人电话
	private int paystate;			// 订单支付状态
	private String orderTime;		// 订单提交时间
	private int userId;				// 用户id
	
	public Order() {
		this.id = 0;
		this.money = 0.0;
		this.receiceAddress = "";
		this.recviceName = "";
		this.recvicePhone = "";
		this.paystate = 0;
		this.orderTime = "2016-01-01 00:00:00";
		this.userId = 0;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getMoney() {
		return money;
	}
	
	public void setMoney(double money) {
		this.money = money;
	}
	
	public String getReceiceAddress() {
		return receiceAddress;
	}
	
	public void setReceiceAddress(String receiceAddress) {
		this.receiceAddress = receiceAddress;
	}
	
	public String getRecviceName() {
		return recviceName;
	}
	
	public void setRecviceName(String recviceName) {
		this.recviceName = recviceName;
	}
	
	public String getRecvicePhone() {
		return recvicePhone;
	}
	
	public void setRecvicePhone(String recvicePhone) {
		this.recvicePhone = recvicePhone;
	}
	
	public int getPaystate() {
		return paystate;
	}
	
	public void setPaystate(int paystate) {
		this.paystate = paystate;
	}
	
	public String getOrderTime() {
		return orderTime;
	}
	
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
