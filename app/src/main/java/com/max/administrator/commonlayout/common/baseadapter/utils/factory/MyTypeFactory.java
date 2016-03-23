package com.max.administrator.commonlayout.common.baseadapter.utils.factory;


import com.max.administrator.commonlayout.common.baseadapter.utils.factory.bean.MyType;

public class MyTypeFactory implements TypeFactory{

	@Override
	public <T extends MyType> T createType(Class<T> clz) {
		MyType type = null;
		try {
			type = (MyType) Class.forName(clz.getName()).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) type;
	}

}
