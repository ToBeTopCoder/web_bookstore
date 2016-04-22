package dao;

/*
 * 订单类
 */
public class Order {
	private int id; 			// not null
	private double price; 		// 订单价格
	private String recvName;
	private String recvPhone;
	private String recvAddress;
	private int userId;
	
	public Order() {
		id = 0;
		price = 0.0;
		recvName = "";
		recvPhone = "";
		recvAddress = "";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRecvName() {
		return recvName;
	}
	public void setRecvName(String recvName) {
		this.recvName = recvName;
	}
	public String getRecvPhone() {
		return recvPhone;
	}
	public void setRecvPhone(String recvPhone) {
		this.recvPhone = recvPhone;
	}
	public String getRecvAddress() {
		return recvAddress;
	}
	public void setRecvAddress(String recvAddress) {
		this.recvAddress = recvAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", price=" + price + ", recvName=" + recvName + ", recvPhone=" + recvPhone
				+ ", recvAddress=" + recvAddress + ", userId=" + userId + "]";
	}
}
