package com.miko.paopao.service;

import com.miko.paopao.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author miko
 */
public interface MissionService {

    /**
     *
     * @param mission
     */
    public void saveMission(Mission mission);


    /**
     *
     * @param missionId
     * @return
     */
    public Mission getById(Long missionId);

    /**
     *
     * @param pageable
     * @return
     */
    Page<Mission> getPage(Pageable pageable);

    /**
     * 更新数据状态
     * @param status
     * @param id
     */
    void updateStatusById(int status, Long id);

    /**
     * 更新数据运行状态
     * @param missionStatus
     * @param id
     */
    void updateMissionStatusById(int missionStatus, Long id);


    /**
     * 接任务
     * @param userId
     * @param missionId
     */
    void takeMission(Long userId,Long missionId);


    /**
     * 分页
     * @param title
     * @param pageable
     * @return
     */
    Page<Mission> getMissionPage(String title,Pageable pageable);

}
