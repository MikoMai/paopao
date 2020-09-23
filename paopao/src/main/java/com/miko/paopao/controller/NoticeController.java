package com.miko.paopao.controller;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Notice;
import com.miko.paopao.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/notice")
@ResponseBody
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    @RequestMapping(value = "/getNoticePage")
    public RetResult<Page<Notice>> getGiftPage(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "page") Integer page){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<Notice> giftPage=noticeService.getNoticePage(pageable);
        return RetResponse.makeOKRsp(giftPage);
    }



}
