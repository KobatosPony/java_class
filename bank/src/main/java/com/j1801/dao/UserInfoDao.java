package com.j1801.dao;

import com.j1801.model.UserInfo;

public interface UserInfoDao {
	/**
	 * 新增一条用户信息
	 * @param userInfo 用户信息
	 * */
	public boolean insert(UserInfo userInfo);
	
	
	/**
	 * 获取id
	 * */
	public Integer getId(UserInfo userInfo);
}
