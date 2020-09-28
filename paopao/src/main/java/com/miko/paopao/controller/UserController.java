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


    @RequestMapping("/login")
    public RetResult<Object> login(@RequestParam(value = "name") String name,@RequestParam(value = "password") String password){

        return userService.login(name, password);
    }

    @RequestMapping("/saveAdmin")
    public RetResult<Object> saveAdmin(@RequestBody User user){
        user.setAdmin(true);
        userService.saveUser(user);
        return RetResponse.makeOKRsp();
    }

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

    @RequestMapping("/updateUser")
    public RetResult<Object> updateUser(@RequestBody User user){
        userService.saveUser(user);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/getUserPage")
    public RetResult<Page<User>> getUserPage(@RequestParam(value = "pageSize") Integer pageSize,@RequestParam(value = "page") Integer page,@RequestParam(value = "name") String name){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<User> userPage=userService.getUserPage(name,false,pageable);
        return RetResponse.makeOKRsp(userPage);
    }


    @RequestMapping(value = "/getAdminPage")
    public RetResult<Page<User>> getAdminPage(@RequestParam(value = "pageSize") Integer pageSize,@RequestParam(value = "page") Integer page,@RequestParam(value = "name") String name){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<User> userPage=userService.getUserPage(name,true,pageable);
        return RetResponse.makeOKRsp(userPage);
    }


    @RequestMapping("/delUser")
    public RetResult<Object> delUser(@RequestParam(value = "id") Long id){
        userService.updateStatusById(3,id);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping("/updatePassword")
    public RetResult<Object> updatePassword(@RequestParam(value = "id") Long id,@RequestParam(value = "password") String  password){
        userService.updatePassword(password,id);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping("/register")
    public RetResult<Object> register(@RequestParam(value = "name") String name,@RequestParam(value = "password") String  password
            ,@RequestParam(value = "phone") String  phone,@RequestParam(value = "birthday") String  birthday,@RequestParam(value = "sex") Integer  sex){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setPhone(phone);
        user.setBirthday(birthday);
        user.setSex(sex);
        return userService.register(user);
    }
}
