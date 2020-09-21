package com.miko.paopao.repository;

import com.miko.paopao.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author miko
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {


    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    @Modifying
    @Query("update News n set n.status=?1 where  n.id=?2")
    void updateStatusById(int status, Long id);

    /**
     * 分页查任务
     * @param title
     * @param pageable
     * @return
     */
    @Query(value = "SELECT n  FROM News n WHERE n.title like %:title%  AND n.status<>3")
    Page<News> findPageByTitle(@Param("title") String title, Pageable pageable);
}
