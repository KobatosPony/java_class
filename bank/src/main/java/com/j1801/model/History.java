package com.j1801.model;

import java.sql.Timestamp;

public class History {
	private Integer id;
	private Integer operation; // 操作类型
	private Double money; // 金额
	private String fromId; // 起始
	private String toId; // 目标
	private Timestamp time; // 时间
	
	public History() {
		
	}

	public History(Integer id, Integer operation, Double money, String fromId, String toId, Timestamp time) {
		super();
		this.id = id;
		this.operation = operation;
		this.money = money;
		this.fromId = fromId;
		this.toId = toId;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOperation() {
		return operation;
	}

	public void setOperation(Integer operation) {
		this.operation = operation;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", operation=" + operation + ", money=" + money + ", fromId=" + fromId + ", toId="
				+ toId + ", time=" + time + "]";
	}
	
}
