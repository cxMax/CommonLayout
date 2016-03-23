package com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean;


import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.LoginItem;

import java.util.List;

/**
 * MyType代表:账号\验证码,密码等类型,一个类型属于一个XML布局文件
 * @author max
 *
 */
public interface MyType {
	public List<LoginItem> selfType();
}
