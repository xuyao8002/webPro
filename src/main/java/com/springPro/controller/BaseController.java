package com.springPro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springPro.dao.EhCacheDao;

@Controller
@RequestMapping("base")
public class BaseController {

	@Autowired
	private EhCacheDao ehCacheDao;
	
    private int i = 0;

    @RequestMapping("show")
    @ResponseBody
    public ModelAndView show(){
		
		return new ModelAndView("index", "message", "hello spring security!");
    }
    
    @RequestMapping("cache/get/{key}")
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
    }
    
}
