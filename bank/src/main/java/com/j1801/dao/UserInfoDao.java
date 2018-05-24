package com.j1801.dao;

import com.j1801.model.UserInfo;

public interface UserInfoDao {
	/**
	 * 取款
	 * @param reduceMoney 取款金额
	 * @param userInfo 用户信息
	 * */
	public boolean drawMoney(Double reduceMoney,UserInfo userInfo);
	/**
	 * 存款
	 * @param addMoney 存款金额
	 * @param userInfo 用户信息
	 * */
	public boolean deposit(Double addMoney,UserInfo userInfo);
	
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
