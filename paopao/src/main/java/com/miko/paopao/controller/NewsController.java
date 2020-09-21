package com.miko.paopao.controller;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Gift;
import com.miko.paopao.entity.News;
import com.miko.paopao.service.GiftService;
import com.miko.paopao.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author miko
 */
@Controller
@RequestMapping("/news")
@ResponseBody
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping("/saveNews")
    public RetResult<Object> saveNews(@RequestBody News news){
        newsService.save(news);
        return RetResponse.makeOKRsp();
    }


    @RequestMapping(value = "/getNews")
    public RetResult<News> getNews(@RequestParam(value = "id") Long id){
        News news=newsService.getOneById(id);
        return RetResponse.makeOKRsp(news);
    }

    @RequestMapping("/updateNews")
    public RetResult<Object> updateNews(@RequestBody News news){
        newsService.save(news);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/getNewsPage")
    public RetResult<Page<News>> getNewsPage(@RequestParam(value = "title") String title,@RequestParam(value = "pageSize") Integer pageSize,@RequestParam(value = "page") Integer page){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<News> giftPage=newsService.getNewsPageByTitle(title,pageable);
        return RetResponse.makeOKRsp(giftPage);
    }



    @RequestMapping("/updateStatus")
    public RetResult<Object> updateStatus(@RequestParam(value = "newsId") Long newsId,@RequestParam(value = "status") int status){
        newsService.updateStatusById(status,newsId);
        return RetResponse.makeOKRsp();
    }

}
