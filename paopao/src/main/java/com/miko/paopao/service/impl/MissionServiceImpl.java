package com.miko.paopao.service.impl;


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
}
