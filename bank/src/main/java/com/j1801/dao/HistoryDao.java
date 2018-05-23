package com.j1801.dao;

import java.util.List;

import com.j1801.model.History;

public interface HistoryDao {
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
