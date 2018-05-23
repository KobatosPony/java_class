package com.j1801.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.j1801.dao.HistoryDao;
import com.j1801.model.History;
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
			if (ptmt.executeLargeUpdate()>0) {
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

}
