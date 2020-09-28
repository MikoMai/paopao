package com.miko.paopao.service;

import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author miko
 */
public interface UserService {

    /**
     *保存用户
     * @param user
     */
    public void saveUser(User user);

    /**
     * 获取用户
     * @param userId
     * @return
     */
    public User getUserById(Long userId);

    /**
     * 获取用户分页
     * @param pageable
     * @return
     */
    Page<User> getUserPage(String name,boolean isAdmin,Pageable pageable) ;

    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    void updateStatusById(int status, Long id);


    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    RetResult<Object> login(String name, String password);


    /**
     * 修改密码
     * @param password
     * @param id
     */
    void updatePassword(String password, Long id);

    /**
     * 注册
     * @param user
     * @return
     */
    RetResult<Object> register(User user);
}
