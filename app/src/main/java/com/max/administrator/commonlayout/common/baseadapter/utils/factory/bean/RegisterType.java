package com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 账号密码登录
 * @author max
 *
 */
public class RegisterType implements MyType{

	@Override
	public List<LoginItem> selfType() {
		List<LoginItem> items = new ArrayList<>();
		items.add(new LoginItem("1")); //初始化一个登录账号
		items.add(new LoginItem("1")); //初始化一个密码
		return items;
	}

}
