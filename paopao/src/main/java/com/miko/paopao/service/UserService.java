package com.miko.paopao.service;

import com.miko.paopao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author miko
 */
public interface UserService {

    /**
     *
     * @param user
     */
    public void saveUser(User user);


    public User getUserById(Long userId);

    Page<User> getUserPage(Pageable pageable);
}
