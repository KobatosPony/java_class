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

	// 用户登录的方法
	public static void login(Scanner scan) {
		System.out.println("请输入卡号:");
		String id = scan.next();
		System.out.println("请输入密码:");
		String password = scan.next();
		
		User user = new UserDaoImp().find_user(id, password);
		if (user != null) {
			System.out.println("登录成功！");
			while(true) {
				loginSuccess(scan,user);
			}
		}else {
			System.out.println("账号密码错误！");
		}
	}

	private static void loginSuccess(Scanner scan,User user) {
		System.out.println("==================");
		System.out.println("请输入指令操作:");
		System.out.println("1-余额查询");
		System.out.println("2-修改密码");
		System.out.println("3-存钱");
		System.out.println("4-取钱");
		System.out.println("5-转账");
		System.out.println("6-历史记录");
		System.out.println("7-退出系统");
		
		UserInfoDaoImp uid = new UserInfoDaoImp();
		UserDaoImp ud = new UserDaoImp();
		UserInfo userInfo = uid.getInfoByUser(user);
		Integer op = scan.nextInt();
		HistoryDaoImp hd = new HistoryDaoImp();
		User toUser = null;
		UserInfo toUserInfo = null;
		History h = null;
		
		switch (op) {
		case 1:
			if (userInfo!=null) {
				System.out.println(userInfo.getDmoney());
			}
			else {
				System.out.println("出错了！");
			}
			break;
		case 2:
			System.out.println("请输入新密码:");
			String newPassword = scan.next();
			if (ud.updatePassword(newPassword,user)) {
				System.out.println("修改成功！");
				user.setPassword(newPassword);
			}else {
				System.out.println("修改失败！");
			}
			break;
		case 3:
			System.out.println("请输入存款金额:");
			Double addMoney = scan.nextDouble();
			
			h = new History(null,3,addMoney,user.getId(),user.getId(),null);
			if (uid.deposit(addMoney, userInfo) && hd.insert(h)) {
				System.out.println("操作成功！");
				userInfo.setDmoney(addMoney+userInfo.getDmoney());
			}else {
				System.out.println("操作失败！");
			}
			
			break;
		case 4:
			System.out.println("请输入取款金额:");
			Double reduceMoney = scan.nextDouble();
			
			h = new History(null,2,reduceMoney,user.getId(),user.getId(),null);
			if (uid.drawMoney(reduceMoney, userInfo) && hd.insert(h)) {
				System.out.println("操作成功！");
				userInfo.setDmoney(userInfo.getDmoney()-reduceMoney);
			}else {
				System.out.println("操作失败！");
			}
			break;
		case 5:
			System.out.println("请输入转账对象账号:");
			String toId = scan.next();
			System.out.println("请输入转账金额:");
			Double transMoney = scan.nextDouble();
			
			h = new History(null,4,transMoney,user.getId(),toId,null);
			toUser = ud.find_user_byid(toId);
			if (toUser==null) {
				System.out.println("转账对象不存在！");
			}else {
				toUserInfo = uid.getInfoByUser(toUser);
				boolean a_res = uid.drawMoney(transMoney, userInfo);
				boolean b_res = uid.deposit(transMoney, toUserInfo);
				if (a_res && b_res && hd.insert(h)) {
					System.out.println("操作成功！");
					userInfo.setDmoney(userInfo.getDmoney()-transMoney);
				}else {
					System.out.println("操作失败！");
				}
			}
			
			break;
		case 6:
			hd.displayHistory(10,user);
			break;
		case 7:
			System.exit(0);
			break;

		default:
			break;
		}
	}


	public static void cancel(Scanner scan) {
		// TODO Auto-generated method stub
		
	}
}
