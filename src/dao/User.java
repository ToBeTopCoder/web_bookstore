package dao;

/*
 * 用户类 对应数据表user，表结构可查看db.sql文件
 * @author: luoxn28
 * @date: 2016.5.13
 */
public class User {
	private int id;				// 自增id，主键
	private String username;	// 用户名
	private String password;	// 密码
	private String gender;		// 性别 "男"或者"女"
	private String email;		// 邮箱
	private String phone;		// 手机
	private String introduce;	// 个人说明
	private String activeCode;	// 激活码
	private int state;			// 用户激活状态 0:未激活 1:已激活
	private String role;		// 用户角色，是否为管理员 管理员:"admin" 会员:""
	private String registTime;	// 用户注册时间 2016-01-01 00:00:00""

	public User() {
		this.id = 0;
		this.username = "";
		this.password = "";
		this.gender = "男";
		this.email = "";
		this.phone = "";
		this.introduce = "";
		this.activeCode = "";
		this.state = 0;
		this.role = "";
		this.registTime = "2016-01-01 00:00:00";
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
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
	
	public String getActiveCode() {
		return activeCode;
	}
	
	public void setActiveCode(String activeCode) {
		this.activeCode = activeCode;
	}
	
	public int getState() {
		return state;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getRegistTime() {
		return registTime;
	}
	
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
}
