package com.test.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		String cacheString = "/cache-bean.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(
				cacheString);
		
		//获取代理工厂proxyFactory生成的bean，以便产生拦截效果
		ServiceManager testService = (ServiceManager) context.getBean("proxyFactory");

		// 第一次查找
		System.out.println("=====第一次查找");
		testService.getObject();

		// 第二次查找
		System.out.println("=====第二次查找");
		testService.getObject();

		// 执行update方法（应该清除缓存）
		System.out.println("=====第一次更新");
		testService.updateObject(null);

		// 第三次查找
		System.out.println("=====第三次查找");
		testService.getObject();
    } 
}
