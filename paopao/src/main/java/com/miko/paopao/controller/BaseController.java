package com.miko.paopao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/base")
@ResponseBody
public class BaseController {

    @RequestMapping("/getBase")
    public String getBase(){
        return "base222";
    }
}
