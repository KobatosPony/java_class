package com.j1801.dao;

import java.util.List;

import com.j1801.model.History;
import com.j1801.model.User;

public interface HistoryDao {
	/**
	 * 显示历史操作
	 * @param count 显示的条数
	 * @param user	用户
	 * */
	public void displayHistory(Integer count,User user);
	/**
	 * 插入一个历史
	 * @param history
	 * */
	public boolean insert(History history);
	
	public List<History> findAll();
	
	/**
	 * 根据操作类型查询
	 * @param i 1-开户，2-取钱，3-存钱，4-转账
	 * */
	public List<History> findByOperation(Integer i);
	
	public List<History> findById(String id);

	public List<History> findByDate(String date);
}
