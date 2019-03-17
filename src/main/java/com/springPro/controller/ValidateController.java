package com.springPro.controller;

import com.springPro.entity.TestInfoDto;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/validate")
public class ValidateController {

    @RequestMapping("/valid")
    @ResponseBody
    public Map<String, Object> valid(@Valid TestInfoDto testInfo, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            List<ObjectError> errorList = bindingResult.getAllErrors();
            for(ObjectError error : errorList){
                System.out.println(error.getDefaultMessage());
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("data", testInfo);
        return map;
    }
}
