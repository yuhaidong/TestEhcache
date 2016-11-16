package com.test.ehcache;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.ehcache.Cache;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

public class CacheAfterReturningAdvice implements AfterReturningAdvice,
		InitializingBean {

	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}

	public CacheAfterReturningAdvice() {
		super();
	}

	public void afterReturning(Object arg0, Method arg1, Object[] arg2,
			Object arg3) throws Throwable {
		String className = arg3.getClass().getName();
		List list = cache.getKeys();
		for (int i = 0; i < list.size(); i++) {
			String cacheKey = String.valueOf(list.get(i));
			if (cacheKey.startsWith(className)) {
				cache.remove(cacheKey);
				System.out.println("-----清除缓存");
			}
		}
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cache,
				"Need a cache. Please use setCache(Cache) create it.");
	}

}
