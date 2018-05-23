package com.j1801.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.j1801.ctrl.LogicService;
import com.j1801.dao.Impl.UserDaoImp;
import com.j1801.model.User;
import com.wang.db.DbHelper;

public class Application {

	public static void main(String[] args) {
		start();
	}
	
	private static void start() {
		System.out.println("=== xxxbank欢迎您! ===");
		System.out.println("请输入指令操作:");
		System.out.println("1-注册");
		System.out.println("2-登录");
		System.out.println("3-注销");
		Scanner scan = new Scanner(System.in);
		if (scan.hasNextInt()) {
			Integer op = scan.nextInt();
			switch(op) {
			case 1:
				{
					// 注册功能
					LogicService.regist(scan);
				}
				break;
			case 2:
				{
					// 登录功能
					LogicService.login(scan);
				}
				break;
			case 3:
				{
					// 注销功能
					LogicService.cancel(scan);
				}
				break;
			default:
				break;
			}
		}
	}

	public static void test() {
		UserDaoImp ud = new UserDaoImp();
		User user = new User("100861","000111",1);
		if (ud.insert_user(user)) {
			System.out.println("注册成功！");
		}
		else {
			System.out.println("注册失败");
		}
	}
}
