package com.miko.paopao.service;

import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author miko
 */
public interface NewsService {

    /**
     *保存用户
     * @param news
     */
    public void save(News news);

    /**
     * 获取用户
     * @param id
     * @return
     */
    public News getOneById(Long id);

    /**
     * 获取用户分页
     * @param title
     * @param pageable
     * @return
     */
    Page<News> getNewsPageByTitle(String title, Pageable pageable);

    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    void updateStatusById(int status, Long id);


}
