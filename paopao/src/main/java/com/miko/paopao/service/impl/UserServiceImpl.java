package com.miko.paopao.service.impl;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.User;
import com.miko.paopao.repository.UserRepository;
import com.miko.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveUser(User user){
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public Page<User> getUserPage(String name,boolean isAdmin,Pageable pageable) {
        return userRepository.findPageByName(name,isAdmin,pageable);
    }

    @Override
    public void updateStatusById(int status, Long id) {
        userRepository.updateStatusById(status,id);
    }

    @Override
    public RetResult<Object> login(String name, String password) {
        User user=userRepository.findByNameAndPassword(name,password);
        if(user==null){
            return  RetResponse.makeErrRsp("用户名或密码错误!");
        }
        return RetResponse.makeOKRsp(user);
    }

    @Override
    public void updatePassword(String password, Long id) {
        userRepository.updatePassword(password,id);
    }

    @Override
    public RetResult<Object> register(User user) {
        if(StringUtils.isEmpty(user.getPhone()) ){
            return RetResponse.makeErrRsp("电话号码不能为空");
        }
        User checkUser = userRepository.findByPhone(user.getPhone());
        if (checkUser != null) {
            return RetResponse.makeErrRsp("电话号码已注册");
        }
        userRepository.save(user);
        return RetResponse.makeOKRsp(user);
    }
}
