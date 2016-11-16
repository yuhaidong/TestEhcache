package com.test.service;

import java.util.ArrayList;
import java.util.List;

public class ServiceManagerImpl implements ServiceManager {

	@Override
	public List getObject() {
		System.out.println("-----ServiceManager：缓存Cache内不存在该element，查找数据库，并放入Cache！");
		
		return null;
	}

	@Override
	public void updateObject(Object Object) {
		System.out.println("-----ServiceManager：更新了对象，这个类产生的cache都将被remove！");
	}

}
