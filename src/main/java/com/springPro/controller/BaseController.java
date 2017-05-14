package com.springPro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("base")
public class BaseController {

    private int i = 0;

    @RequestMapping("show")
    @ResponseBody
    public ModelAndView show(){
		
		return new ModelAndView("index", "message", "hello spring security!");
    }
 
    
}
