package com.miko.paopao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base")
public class BaseController {

    @RequestMapping("/getBase")
    public String getBase(){
        return "base";
    }
}
