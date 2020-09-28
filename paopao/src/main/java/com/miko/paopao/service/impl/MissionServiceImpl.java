package com.miko.paopao.service.impl;


import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Mission;
import com.miko.paopao.entity.Notice;
import com.miko.paopao.entity.User;
import com.miko.paopao.entity.dataenum.NoticeType;
import com.miko.paopao.repository.MissionRepository;
import com.miko.paopao.service.MissionService;
import com.miko.paopao.service.NoticeService;
import com.miko.paopao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class MissionServiceImpl implements MissionService {

    @Autowired
    private MissionRepository missionRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private NoticeService noticeService;

    @Override
    public void saveMission(Mission mission) {
        missionRepository.save(mission);
    }

    @Override
    public Mission getById(Long missionId) {
        return missionRepository.getOne(missionId);
    }

    @Override
    public Page<Mission> getPage(Pageable pageable) {
        return missionRepository.findAll(pageable);
    }

    @Override
    public void updateStatusById(int status, Long id) {
        missionRepository.updateStatusById(status,id);
    }

    @Override
    public void updateMissionStatusById(int missionStatus, Long id) {
        missionRepository.updateMissionStatusById(missionStatus,id);
        if(missionStatus==3){
            Mission mission=this.getById(id);
            User user=mission.getFinishByUser();
            user.setIntegral(user.getIntegral()+mission.getIntegral());
            userService.saveUser(user);
        }
    }

    @Override
    public void takeMission(Long userId, Long missionId) {
        User user=userService.getUserById(userId);
        Mission mission=this.getById(missionId);
        mission.setFinishByUser(user);
        mission.setMissionStatus(2);
        this.saveMission(mission);
        Notice notice=new Notice();
        notice.setType(NoticeType.MISSION);
        notice.setContent("[跑跑家族]:"+user.getName()+"已接受了你的跑腿任务--"+mission.getTitle());
        notice.setNoticeToUser(mission.getCreateByUser());
        notice.setNoticeFromUser(user);
        noticeService.saveNotice(notice);

    }

    @Override
    public Page<Mission> getMissionPage(String title, Pageable pageable) {
        return missionRepository.findPageByTitle(title,pageable);
    }

    @Override
    public Page<Mission> getNewMissionPage(Pageable pageable) {
        return missionRepository.findNewMissionPage(pageable);
    }

    @Override
    public List<Mission> getAllMissionByFinishUser(long userId) {
        User user=userService.getUserById(userId);
        return missionRepository.findAllByFinishByUser(user);
    }

    @Override
    public List<Mission> getAllMissionByCreateUser(long userId) {
        User user=userService.getUserById(userId);
        return missionRepository.findAllByCreateByUser(user);
    }

    @Override
    public RetResult<Object> saveMissionByUser(Mission mission) {
        User user=userService.getUserById(mission.getCreateByUser().getId());
      if(user.getIntegral()<mission.getIntegral()){
          return RetResponse.makeErrRsp("积分不足,无法创建任务,请先帮助他人获取更多积分吧");
      }
        mission.setPhone(user.getPhone());
        this.saveMission(mission);
        return RetResponse.makeOKRsp(mission);
    }



}
