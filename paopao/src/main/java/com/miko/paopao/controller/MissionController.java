package com.miko.paopao.controller;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Mission;
import com.miko.paopao.service.MissionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/mission")
@ResponseBody
public class MissionController {

    @Resource
    private MissionService missionService;

    @RequestMapping("/saveMission")
    public RetResult<Object> saveMission(@RequestBody Mission mission){
        missionService.saveMission(mission);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/getMission")
    public RetResult<Mission> getMission(@RequestParam(value = "missionId") Long missionId){
        Mission mission=missionService.getById(missionId);
        return RetResponse.makeOKRsp(mission);
    }


    @RequestMapping("/updateMission")
    public RetResult<Object> updateMission(@RequestBody Mission mission){
        missionService.saveMission(mission);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping("/updateStatus")
    public RetResult<Object> updateStatus(@RequestParam(value = "missionId") Long missionId,@RequestParam(value = "status") int status){
        missionService.updateStatusById(status,missionId);
        return RetResponse.makeOKRsp();
    }
    @RequestMapping("/updateMissionStatus")
    public RetResult<Object> updateMissionStatus(@RequestParam(value = "missionId") Long missionId,@RequestParam(value = "missionStatus") int missionStatus){
        missionService.updateMissionStatusById(missionStatus,missionId);
        return RetResponse.makeOKRsp();
    }
    @RequestMapping("/takeMission")
    public RetResult<Object> takeMission(@RequestParam(value = "missionId") Long missionId,@RequestParam(value = "userId") Long userId){
        missionService.takeMission(userId,missionId);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/getMissionPage")
    public RetResult<Page<Mission>> getMissionPage(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "page") Integer page, @RequestParam(value = "title") String title){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<Mission> missionPage=missionService.getMissionPage(title,pageable);
        return RetResponse.makeOKRsp(missionPage);
    }
    @RequestMapping(value = "/getMissionPage2")
    public RetResult<Page<Mission>> getMissionPage2(@RequestParam(value = "pageSize") Integer pageSize, @RequestParam(value = "page") Integer page){
        Pageable pageable =  PageRequest.of(page-1,pageSize);
        Page<Mission> missionPage=missionService.getNewMissionPage(pageable);
        return RetResponse.makeOKRsp(missionPage);
    }

    @RequestMapping(value = "/getAllMissionByFinishUser")
    public RetResult<List<Mission>> getAllMissionByFinishUser(@RequestParam(value = "userId") Integer userId){
        List<Mission> missionList=missionService.getAllMissionByFinishUser(userId);
        return RetResponse.makeOKRsp(missionList);
    }

    @RequestMapping(value = "/getAllMissionByCreateUser")
    public RetResult<List<Mission>> getAllMissionByCreateUser(@RequestParam(value = "userId") Integer userId){
        List<Mission> missionList=missionService.getAllMissionByCreateUser(userId);
        return RetResponse.makeOKRsp(missionList);
    }

    @RequestMapping("/saveMissionByUser")
    public RetResult<Object> saveMissionByUser(@RequestBody Mission mission){
        return missionService.saveMissionByUser(mission);
    }
}
