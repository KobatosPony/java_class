package com.j1801.model;

import com.j1801.dao.Impl.UserDaoImp;

public class User {
	private String id; // 卡号
	private String password; // 密码
	private Integer uInfoId; // 用户详细信息的id
	
	public User() {
		this.id = randomId();
	}
	
	private String randomId() {
		String id = "";
		UserDaoImp ud = new UserDaoImp();
		while(true) {
			int d = (int)Math.ceil(Math.random()*1000000);
			id = ""+d;
			for(int i=id.length();i<6;i++) {
				id = "0"+id;
			}
			// 查询在不在数据库中
			if (!ud.find_user(id)) {
				break;
			}
		}
		return id;
	}

	public User(String id, String password, Integer uInfoId) {
		super();
		this.id = id;
		this.password = password;
		this.uInfoId = uInfoId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getuInfoId() {
		return uInfoId;
	}

	public void setuInfoId(Integer uInfoId) {
		this.uInfoId = uInfoId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", uInfoId=" + uInfoId + "]";
	}
}
