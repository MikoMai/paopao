package com.miko.paopao.service;

import com.miko.paopao.entity.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author miko
 */
public interface NoticeService {

    /**
     *新增通知
     * @param notice
     */
    public void saveNotice(Notice notice);

    /**
     * 获取用户分页
     * @param pageable
     * @return
     */
    Page<Notice> getNoticePage(Pageable pageable);

}
