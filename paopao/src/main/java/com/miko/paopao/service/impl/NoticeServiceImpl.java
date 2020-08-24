package com.miko.paopao.service.impl;

import com.miko.paopao.entity.Notice;
import com.miko.paopao.repository.NoticeRepository;
import com.miko.paopao.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author miko
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Override
    public void saveNotice(Notice notice) {
        noticeRepository.save(notice);
    }

    @Override
    public Page<Notice> getNoticePage(Pageable pageable) {
        return noticeRepository.findAll(pageable);
    }
}
