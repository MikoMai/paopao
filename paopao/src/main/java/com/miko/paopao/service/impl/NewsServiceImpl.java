package com.miko.paopao.service.impl;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Gift;
import com.miko.paopao.entity.News;
import com.miko.paopao.entity.Notice;
import com.miko.paopao.entity.User;
import com.miko.paopao.entity.dataenum.NoticeType;
import com.miko.paopao.repository.GiftRepository;
import com.miko.paopao.repository.NewsRepository;
import com.miko.paopao.service.GiftService;
import com.miko.paopao.service.NewsService;
import com.miko.paopao.service.NoticeService;
import com.miko.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public void save(News news) {
        newsRepository.save(news);
    }

    @Override
    public News getOneById(Long id) {
        return newsRepository.getOne(id);
    }

    @Override
    public Page<News> getNewsPageByTitle(String title,Pageable pageable) {
        return newsRepository.findPageByTitle(title,pageable);
    }

    @Override
    public void updateStatusById(int status, Long id) {
        newsRepository.updateStatusById(status, id);
    }



}
