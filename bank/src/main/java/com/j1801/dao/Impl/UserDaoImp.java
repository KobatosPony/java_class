package com.j1801.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.j1801.dao.UserDao;
import com.j1801.model.User;
import com.wang.db.DbHelper;

public class UserDaoImp implements UserDao{

	public boolean delete_user(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean insert_user(User user) {
		// 获取连接对象
		PreparedStatement pStatement = null;
		Connection connection = DbHelper.getConn();
		String sql = "insert into user values(?,?,?)";
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, user.getId());
			pStatement.setString(2, user.getPassword());
			pStatement.setInt(3, user.getuInfoId());
			
			// 执行更新
			if (pStatement.executeUpdate()>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// finally 始终会执行
		}finally {
			if (pStatement != null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public User find_user(String id, String password) {
		PreparedStatement pStatement = null;
		Connection connection = DbHelper.getConn();
		String sql = "select * from user where id=? and password=?";
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, id);
			pStatement.setString(2, password);
			ResultSet rSet = pStatement.executeQuery();
			while(rSet.next()) {
				User user = new User(rSet.getString("id"),rSet.getString("password"),rSet.getInt("uInfoId"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pStatement!=null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public User find_user_byid(String id) {
		Connection connection = DbHelper.getConn();
		PreparedStatement ptmt = null;
		String sql = "select * from user where id=?";
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, id);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				return new User(rs.getString("id"), rs.getString("password"), rs.getInt("uinfoid"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ptmt!=null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// 判断用户是否存在
	public boolean find_user(String id) {
		Connection connection = DbHelper.getConn();
		PreparedStatement ptmt = null;
		String sql = "select * from user where id=?";
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, id);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (ptmt!=null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean updatePassword(String newPassword,User user) {
		Connection connection = DbHelper.getConn();
		PreparedStatement ptmt = null;
		String sql = "update user set password=? where id=?";
		
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, newPassword);
			ptmt.setString(2, user.getId());
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
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
