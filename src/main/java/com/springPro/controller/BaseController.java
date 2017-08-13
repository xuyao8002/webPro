package com.springPro.controller;

import java.util.UUID;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springPro.dao.BaseDao;
import com.springPro.dao.UsTriggerFrequencyDao;
import com.springPro.entity.TestInfo;
import com.springPro.entity.UsTriggerFrequency;
import com.springPro.service.BaseService;

@Controller
@RequestMapping("base")
public class BaseController {

	/*@Autowired
	private EhCacheDao ehCacheDao;*/
	
	@Autowired
	private BaseService baseService;
	
	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private UsTriggerFrequencyDao usTriggerFrequencyDao;

	private int i = 0;

	@RequestMapping(value = "code", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String code(TestInfo testInfo){
		return "i'am testing http \r\n"+testInfo;
    }
	
	public static void main(String[] args){
		Vector v = new Vector(18);
		v.add("haha");
		System.out.println(v.capacity());
		System.out.println(v.size());
	}
	
    @RequestMapping("show")
    @ResponseBody
    public ModelAndView show(){
		
		return new ModelAndView("index", "message", "hello spring security!");
    }
    
    @RequestMapping("test/{key}")
    @ResponseBody
    public String test(@PathVariable("key") String key){
    	UsTriggerFrequency f = new UsTriggerFrequency();
    	f.setCustomerId(UUID.randomUUID().toString().replace("-", ""));
    	f.setId("haha");
    	f.setMaxSend(8);
    	f.setSeconds(9);
    	f.setStatus((byte)2);
    	f.setTimes(10);
    	f.setType((byte)1);
    	usTriggerFrequencyDao.insert(f);
		return key + ", " + baseDao;
    }
    
    /*@RequestMapping("cache/get/{key}")
    @ResponseBody
    public String cacheget(@PathVariable("key") String key){
		return ehCacheDao.get(key);
    }
 
    @RequestMapping("cache/put/{key}/{value}/{i}/{j}")
    @ResponseBody
    public String cacheput(@PathVariable("key") String key, @PathVariable("value") String value, 
			@PathVariable("i") int i, @PathVariable("j") int j){
    	ehCacheDao.put(key, value, i, j);
		return key + ", " + value + ", " + i + ", " + j;
    }*/
    
}
