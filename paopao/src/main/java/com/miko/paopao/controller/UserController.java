package com.miko.paopao.controller;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.User;
import com.miko.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/saveUser")
    public RetResult<Object> saveUser(@RequestBody User user){
        userService.saveUser(user);
        return RetResponse.makeOKRsp();
    }


    @RequestMapping(value = "/getUser")
    public RetResult<User> getUser(@RequestParam(value = "userId") Long userId){
        User user=userService.getUserById(userId);
        return RetResponse.makeOKRsp(user);
    }

    @RequestMapping(value = "/getUserPage")
    public RetResult<Page<User>> getUserPage(@RequestParam(value = "pageSize") Integer pageSize,@RequestParam(value = "page") Integer page){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<User> userPage=userService.getUserPage(pageable);
        return RetResponse.makeOKRsp(userPage);
    }
}
