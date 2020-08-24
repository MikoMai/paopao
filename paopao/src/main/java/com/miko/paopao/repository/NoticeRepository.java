package com.miko.paopao.repository;

import com.miko.paopao.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository  extends JpaRepository<Notice, Long> {
}
