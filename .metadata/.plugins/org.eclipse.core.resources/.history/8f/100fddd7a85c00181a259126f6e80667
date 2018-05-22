package com.wang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Application {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		try {
			// 获取连接对象
		    conn =DriverManager.getConnection("jdbc:mysql://localhost/jdbctest?" +
		                 "user=root&password=8844248&useSSL=false");
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		// 创建一个sql的执行对象
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT * FROM student";
		// 使用stmt可以指向sql语句，返回查询结果集
		ResultSet rs = stmt.executeQuery(sql);
		// rs结果集对象，可以使用next方法判断是否有数据
		while(rs.next()) {
			System.out.print("id=" + rs.getInt("id"));
			System.out.println(",name="+rs.getString("name"));
		}
	}
}
