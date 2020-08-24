package com.miko.paopao.repository;

import com.miko.paopao.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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
}
