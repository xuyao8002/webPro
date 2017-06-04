package com.springPro.factory;

import java.util.Properties;

import com.springPro.listener.EhCacheListener;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;

public class EhCacheEventListenerFactory extends CacheEventListenerFactory {

	@Override
	public CacheEventListener createCacheEventListener(Properties arg0) {
		return new EhCacheListener();
	}

}
