package com.springPro.controller;

import com.springPro.dao.BaseDao;
import com.springPro.dao.UsTriggerFrequencyDao;
import com.springPro.entity.TestInfo;
import com.springPro.entity.UsTriggerFrequency;
import com.springPro.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/base")
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

	@RequestMapping(value = "code")
    @ResponseBody
    public Map<String, Object> code(TestInfo testInfo, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", testInfo);
		System.out.println(request.getParameter("name"));
		return map;
    }
	
    @RequestMapping("show")
    @ResponseBody
    public ModelAndView show(){
		System.out.println(System.getProperty("webPro"));

		return new ModelAndView("index", "message", "xuyao");
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
