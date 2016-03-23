package com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * 修改性别
 * @author max
 *
 */
public class ModifySexType implements MyType{

	@Override
	public List<LoginItem> selfType() {
		List<LoginItem> items = new ArrayList<>();
		items.add(new LoginItem("3")); //初始化一个密码
		items.add(new LoginItem("3")); //初始化一个密码
		return items;
	}

}
