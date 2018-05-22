package com.wang.object;

public class Student {
	private String sno;
	private String sname;
	private String ssex;
	private String sbirthday;
	private String sclass;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String sno, String sname, String ssex, String sbirthday, String sclass) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.ssex = ssex;
		this.sbirthday = sbirthday;
		this.sclass = sclass;
	}



	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSbirthday() {
		return sbirthday;
	}
	public void setSbirthday(String sbirthday) {
		this.sbirthday = sbirthday;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	
	@Override
	public String toString() {
		return sno+":"+sname+":"+ssex+":"+sbirthday+":"+sclass;
	}
}
