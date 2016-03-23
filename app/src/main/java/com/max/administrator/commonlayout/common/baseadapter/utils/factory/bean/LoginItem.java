package com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean;

/**
 * 登录每一个的Item
 * 
 * @author max
 * 
 */
public class LoginItem {
	private String type; // "0"代表有验证码账号,"1"代表密码,"2"代表没验证码的账号,3代表修改性别,4代表修改名字

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LoginItem(String type) {
		super();
		this.type = type;
	}

}
