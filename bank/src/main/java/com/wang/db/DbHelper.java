package com.wang.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//获取连接对象

public class DbHelper {
	private static Connection conn;
	
	// 创建静态块
//	static {
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost/bank?"+
//					"user=root&password=8844248&useSSL=false&characterEncoding=utf-8&autoReconnect=true");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public static Connection getConn() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bank?"+
					"user=root&password=8844248&useSSL=false&characterEncoding=utf-8&autoReconnect=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void setConn(Connection conn) {
		DbHelper.conn = conn;
	}
}
