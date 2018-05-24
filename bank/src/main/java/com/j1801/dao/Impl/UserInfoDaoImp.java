package com.j1801.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.j1801.dao.UserInfoDao;
import com.j1801.model.User;
import com.j1801.model.UserInfo;
import com.wang.db.DbHelper;

public class UserInfoDaoImp implements UserInfoDao{
	public UserInfo getInfoByUser(User user) {
		Connection connection = DbHelper.getConn();
		PreparedStatement ptmt = null;
		
		String sql = "select * from userinfo where id=?";
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setInt(1, user.getuInfoId());
			ResultSet rSet = ptmt.executeQuery();
			while(rSet.next()) {
				return new UserInfo(rSet.getInt("id"), rSet.getString("name"), 
						rSet.getInt("sex"), rSet.getLong("mobile"), 
						rSet.getString("address"), rSet.getDouble("dmoney"));
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
	
	public boolean insert(UserInfo userInfo) {
		Connection connection = DbHelper.getConn();
		PreparedStatement ptmt = null;
		String sql = "insert into userinfo(name,sex,mobile,address,dmoney)"
				+"values(?,?,?,?,?)";
		
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, userInfo.getName());
			ptmt.setInt(2, userInfo.getSex());
			ptmt.setLong(3, userInfo.getMobile());
			ptmt.setString(4, userInfo.getAddress());
			ptmt.setDouble(5, userInfo.getDmoney());
			if (ptmt.executeUpdate()>0) {
				return true;
			}
			else {
				return false;
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

	public Integer getId(UserInfo userInfo) {
		Connection connection = DbHelper.getConn();
		PreparedStatement ptmt = null;
		String sql = "select id from userinfo where name=? and sex=? and mobile=? and address=? and dmoney=?";
		
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, userInfo.getName());
			ptmt.setInt(2, userInfo.getSex());
			ptmt.setLong(3, userInfo.getMobile());
			ptmt.setString(4, userInfo.getAddress());
			ptmt.setDouble(5, userInfo.getDmoney());
			ResultSet rSet = ptmt.executeQuery();
			while(rSet.next()) {
				return rSet.getInt("id");
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
		return null;
	}

	public boolean deposit(Double addMoney, UserInfo userInfo) {
		Connection connection = DbHelper.getConn();
		PreparedStatement ptmt = null;
		String sql = "update userinfo set dmoney=? where id=?";
		
		try {
			ptmt = connection.prepareStatement(sql);
			ptmt.setDouble(1, userInfo.getDmoney()+addMoney);
			ptmt.setInt(2, userInfo.getId());
			if (ptmt.executeUpdate()>0) {
				return true;
			}
			else {
				return false;
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

	public boolean drawMoney(Double reduceMoney, UserInfo userInfo) {
		if (reduceMoney>userInfo.getDmoney()) {
			return false;
		}
		else {
			Connection connection = DbHelper.getConn();
			PreparedStatement ptmt = null;
			String sql = "update userinfo set dmoney=? where id=?";
			
			try {
				ptmt = connection.prepareStatement(sql);
				ptmt.setDouble(1, userInfo.getDmoney()-reduceMoney);
				ptmt.setInt(2, userInfo.getId());
				if (ptmt.executeUpdate()>0) {
					return true;
				}
				else {
					return false;
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
}
