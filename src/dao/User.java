package dao;

/*
 * 用户类
 * @notice 用户名在数据表中是唯一的
 */
public class User {
	public final static int MAN = 0;
	public final static int WOMAN = 1;
	
	private int id;				// not null
	private String username;	// not null
	private String password;	// not null
	private String email;		// not null
	private int sex;
	private String phone;
	private String introduce;
	private int isAdmin; // 是否是管理员，0为普通用户，否则为管理员
	
	public User() {
		id = 0;
		username = "";
		password = "";
		email = "";
		sex = MAN;
		phone = "";
		introduce = "";
		isAdmin = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
}
