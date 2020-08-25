package com.miko.paopao.repository;

import com.miko.paopao.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author miko
 */
@Repository
public interface GiftRepository extends JpaRepository<Gift, Long> {


    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    @Modifying
    @Query("update Gift g set g.status=?1 where  g.id=?2")
    void updateStatusById(int status, Long id);

}
