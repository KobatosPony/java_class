package com.j1801.model;

public class UserInfo {
	private Integer id; // id
	private String name; // 姓名
	private Integer sex; // 性别
	private Long mobile; // 手机
	private String address; // 地址
	private Double dmoney; // 存款
	
	public UserInfo() {
		
	}
	

	public UserInfo(Integer id, String name, Integer sex, Long mobile, String address, Double dmoney) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.mobile = mobile;
		this.address = address;
		this.dmoney = dmoney;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getDmoney() {
		return dmoney;
	}

	public void setDmoney(Double dmoney) {
		this.dmoney = dmoney;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", sex=" + sex + ", mobile=" + mobile + ", address=" + address
				+ ", dmoney=" + dmoney + "]";
	}
}
