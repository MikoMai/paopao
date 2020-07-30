package com.miko.paopao.service.impl;

import com.miko.paopao.dao.UserDao;
import com.miko.paopao.entity.User;
import com.miko.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Page<User> getUserPage(Pageable pageable) {
        return userDao.getUserPage(pageable);
    }

}
