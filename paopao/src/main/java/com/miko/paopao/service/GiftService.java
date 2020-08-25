package com.miko.paopao.service;

import com.miko.paopao.entity.Gift;
import com.miko.paopao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author miko
 */
public interface GiftService {

    /**
     *保存用户
     * @param gift
     */
    public void save(Gift gift);

    /**
     * 获取用户
     * @param id
     * @return
     */
    public Gift getOneById(Long id);

    /**
     * 获取用户分页
     * @param pageable
     * @return
     */
    Page<Gift> getGiftPage(Pageable pageable);

    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    void updateStatusById(int status, Long id);


    /**
     *兑换礼物
     * @param userId
     * @param gift
     */
    void takeGift(Long userId,Long gift);
}
