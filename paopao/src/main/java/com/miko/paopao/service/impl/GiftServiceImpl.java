package com.miko.paopao.service.impl;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Gift;
import com.miko.paopao.entity.Notice;
import com.miko.paopao.entity.User;
import com.miko.paopao.entity.dataenum.NoticeType;
import com.miko.paopao.repository.GiftRepository;
import com.miko.paopao.service.GiftService;
import com.miko.paopao.service.NoticeService;
import com.miko.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class GiftServiceImpl implements GiftService {

    @Autowired
    private GiftRepository giftRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private NoticeService noticeService;

    @Override
    public void save(Gift gift) {
        giftRepository.save(gift);
    }

    @Override
    public Gift getOneById(Long id) {
        return giftRepository.getOne(id);
    }

    @Override
    public Page<Gift> getGiftPage(Pageable pageable) {
        return giftRepository.findAll(pageable);
    }

    @Override
    public void updateStatusById(int status, Long id) {
        giftRepository.updateStatusById(status, id);
    }

    @Override
    public RetResult<Object> takeGift(Long userId, Long giftId) {
        User user=userService.getUserById(userId);
        Gift gift=this.getOneById(giftId);
        if (user.getIntegral()<gift.getIntegral()){
            return RetResponse.makeErrRsp("你的积分不足");
        }
        if (gift.getNum()==0){
            return RetResponse.makeErrRsp("该礼物库存不足,请选择其它礼物");
        }
        Notice notice=new Notice();
        notice.setType(NoticeType.GIFT);
        notice.setNoticeToUser(user);
        notice.setContent("你已成功兑换了"+gift.getName());
        noticeService.saveNotice(notice);
        gift.setNum(gift.getNum()-1);
        this.save(gift);
        user.setIntegral(user.getIntegral()-gift.getIntegral());
        userService.saveUser(user);
        return RetResponse.makeOKRsp();
    }
}
