package com.j1801.ctrl;

import java.util.Scanner;

import com.j1801.dao.Impl.HistoryDaoImp;
import com.j1801.dao.Impl.UserDaoImp;
import com.j1801.dao.Impl.UserInfoDaoImp;
import com.j1801.model.History;
import com.j1801.model.User;
import com.j1801.model.UserInfo;


public class LogicService {

	public static void regist(Scanner scan) {
		// 用户详细信息
		UserInfo userInfo = new UserInfo();
		User user = new User();
		
		System.out.println("请输入姓名:");
		userInfo.setName(scan.next());
		System.out.println("请输入性别:（1-男，2-女，3-其他）");
		userInfo.setSex(scan.nextInt());
		System.out.println("请输入手机号:");
		userInfo.setMobile(scan.nextLong());
		System.out.println("请输入家庭住址:");
		userInfo.setAddress(scan.next());
		System.out.println("请输入开户金额:");
		userInfo.setDmoney(scan.nextDouble());
		
		UserInfoDaoImp uid = new UserInfoDaoImp();
		// 如果用户信息写入成功，需要把成功的用户的id赋值给u对象
		if (uid.insert(userInfo)) {
			user.setuInfoId(uid.getId(userInfo));
		}
		
		System.out.println("请输入密码:");
		user.setPassword(scan.next());
		
		HistoryDaoImp hd = new HistoryDaoImp();
		History h = new History(null,1,userInfo.getDmoney(),user.getId(),user.getId(),null);
		
		UserDaoImp ud = new UserDaoImp();
		if (ud.insert_user(user) && hd.insert(h)) {
			System.out.println("开户成功！");
			System.out.println(user);
			// 插入一个历史记录
			
		}
		else {
			System.out.println("开户失败！");
		}
	}

	public static void login(Scanner scan) {
		// TODO Auto-generated method stub
		
	}

	public static void cancel(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
}
