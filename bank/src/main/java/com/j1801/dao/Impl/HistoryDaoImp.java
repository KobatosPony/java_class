package com.j1801.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.j1801.dao.HistoryDao;
import com.j1801.model.History;
import com.j1801.model.User;
import com.sun.org.apache.regexp.internal.recompile;
import com.wang.db.DbHelper;

public class HistoryDaoImp implements HistoryDao{

	public boolean insert(History history) {
		PreparedStatement ptmt = null;
		Connection connection = DbHelper.getConn();
		String sql = "insert into history(operation,money,fromId,toId)"+
				"values(?,?,?,?)";
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1, history.getOperation());
			ptmt.setDouble(2, history.getMoney());
			ptmt.setString(3, history.getFromId());
			ptmt.setString(4, history.getToId());
			if (ptmt.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ptmt!=null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public List<History> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<History> findByOperation(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<History> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<History> findByDate(String date) {
		// TODO Auto-generated method stub
		return null;
	}

	public void displayHistory(Integer count,User user) {
		String opration = null;
		PreparedStatement ptmt = null;
		Connection connection = DbHelper.getConn();
		String sql = "select * from history where fromid=? or toid=? limit ?";
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getId());
			ptmt.setInt(3, count);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				switch (rs.getInt("operation")) {
				case 1:
					opration = "开户";
					break;
				case 2:
					opration = "取钱";
					break;
				case 3:
					opration = "存钱";
					break;
				case 4:
					opration = "转账";
					break;

				default:
					break;
				}
				System.out.println(rs.getInt("id")+" | "+opration+" | "+
						rs.getString("fromId")+" | "+rs.getString("toId")+" | "+
						rs.getDouble("money")+" | "+rs.getTimestamp("time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ptmt!=null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
