package com.springPro.listener;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

public class EhCacheListener implements CacheEventListener {
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementEvicted(Ehcache arg0, Element arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementExpired(Ehcache arg0, Element arg1) {
		// TODO Auto-generated method stub
		
		
		System.out.println("Expired " + arg1.getObjectValue());
	}
	
	@Override
	public void notifyElementPut(Ehcache arg0, Element arg1) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementRemoved(Ehcache arg0, Element arg1) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyElementUpdated(Ehcache arg0, Element arg1) throws CacheException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyRemoveAll(Ehcache arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public Object clone() throws CloneNotSupportedException {  
	      throw new CloneNotSupportedException();  
	}
	
	@SuppressWarnings("unchecked")
	private <T> T getFromCache(Ehcache ehcache, String key) {
		Element element = ehcache.get(key);
		return element == null ? null : (T) element.getObjectValue();
	}
	
}
