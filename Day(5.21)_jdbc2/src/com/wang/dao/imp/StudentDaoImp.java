package com.wang.dao.imp;


import java.util.List;

import com.wang.object.Student;

// 数据访问层接口，只做方法的声明
public interface StudentDaoImp {
	// 查询
	public List<Student> queryAllStudent();
	// 新增
	public boolean insertAStudent(Student stu);
	// 修改
	public boolean updateAStudent(String sno,Student stu);
	// 删除
	public boolean deleteAStudent(String sno);
}
