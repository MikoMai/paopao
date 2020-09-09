package com.miko.paopao.service.impl;

import com.miko.paopao.entity.User;
import com.miko.paopao.repository.UserRepository;
import com.miko.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
