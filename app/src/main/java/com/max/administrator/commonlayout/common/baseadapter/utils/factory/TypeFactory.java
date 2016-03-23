package com.max.administrator.commonlayout.common.baseadapter.utils.factory;

import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.MyType;

/**
 * 工厂接口,返回各种MyType对象
 * @author max
 *
 */
public interface TypeFactory {
	
	public <T extends MyType>T createType(Class<T> clz);
}
