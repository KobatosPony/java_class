package com.j1801.dao;

import com.j1801.model.User;

public interface UserDao {
	/**
	 * 查找用户，会返回用户。
	 * @param id 用户id
	 * */
	public User find_user_byid(String id);
	/**
	 * 修改密码
	 * @param newPassword 新密码
	 * @param user 当前登录用户
	 * @return 是否成功
	 * */
	public boolean updatePassword(String newPassword,User user);
	
	/**
	 * 注销用户
	 * @param user 要注销的用户信息
	 * @return 是否注销成功
	 * */
	public boolean delete_user(User user);
	
	/**
	 * 注册用户
	 * @param user 用户账号密码等信息
	 * @return 是否注册成功
	 * */
	public boolean insert_user(User user);
	
	/**
	 * 根据账号密码查询用户是否存在，用于验证登录
	 * @param id 账号
	 * @param password 密码
	 * @return 查到的记录转换成对象返回
	 * */
	public User find_user(String id,String password);
}
