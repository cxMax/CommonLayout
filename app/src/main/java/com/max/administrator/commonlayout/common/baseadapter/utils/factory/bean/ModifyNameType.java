package com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 修改名字
 * @author max
 *
 */
public class ModifyNameType implements MyType {

	@Override
	public List<LoginItem> selfType() {
		List<LoginItem> items = new ArrayList<>();
		items.add(new LoginItem("4")); //初始化一个clearedittext
		return items;
	}

}
