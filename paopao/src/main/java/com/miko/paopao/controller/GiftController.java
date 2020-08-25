package com.miko.paopao.controller;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Gift;
import com.miko.paopao.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/gift")
@ResponseBody
public class GiftController {

    @Autowired
    private GiftService giftService;

    @RequestMapping("/saveGift")
    public RetResult<Object> saveUser(@RequestBody Gift gift){
        giftService.save(gift);
        return RetResponse.makeOKRsp();
    }


    @RequestMapping(value = "/getGift")
    public RetResult<Gift> getGift(@RequestParam(value = "id") Long id){
        Gift gift=giftService.getOneById(id);
        return RetResponse.makeOKRsp(gift);
    }

    @RequestMapping("/updateGift")
    public RetResult<Object> updateGift(@RequestBody Gift gift){
        giftService.save(gift);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/getGiftPage")
    public RetResult<Page<Gift>> getGiftPage(@RequestParam(value = "pageSize") Integer pageSize,@RequestParam(value = "page") Integer page){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<Gift> giftPage=giftService.getGiftPage(pageable);
        return RetResponse.makeOKRsp(giftPage);
    }


    @RequestMapping("/takeGift")
    public RetResult<Object> takeGift(@RequestParam(value = "userId") Long userId,@RequestParam(value = "giftId") Long giftId){
        giftService.takeGift(userId,giftId);
        return RetResponse.makeOKRsp();
    }

}
