package com.miko.paopao.dao;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.User;
import com.miko.paopao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * @author admin
 */
@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User getUserById(Long userId) {
        return userRepository.getOne(userId);
    }

    public Page<User> getUserPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
