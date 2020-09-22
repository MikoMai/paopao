package com.miko.paopao.repository;

import com.miko.paopao.entity.Mission;
import com.miko.paopao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission, Long> {


    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    @Modifying
    @Query("update Mission m set m.status=?1 where  m.id=?2")
    void updateStatusById(int status, Long id);


    /**
     * 更新数据运行状态
     * @param missionStatus
     * @param id
     */
    @Modifying
    @Query("update Mission m set m.missionStatus=?1 where  m.id=?2")
    void updateMissionStatusById(int missionStatus, Long id);

    /**
     * 分页查任务
     * @param title
     * @param pageable
     * @return
     */
    @Query(value = "SELECT m  FROM Mission m WHERE m.title like %:title%  AND m.status<>3")
    Page<Mission> findPageByTitle(@Param("title") String title, Pageable pageable);

    /**
     * 分页查任务
     * @param pageable
     * @return
     */
    @Query(value = "SELECT m  FROM Mission m WHERE m.missionStatus=1 AND m.status<>3")
    Page<Mission> findNewMissionPage( Pageable pageable);


    /**
     * 分页查任务
     * @param
     * @return
     */
    List<Mission> findAllByFinishByUser(User user);
}
