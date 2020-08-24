package com.miko.paopao.controller;

import com.miko.paopao.base.response.RetResponse;
import com.miko.paopao.base.response.RetResult;
import com.miko.paopao.entity.Mission;
import com.miko.paopao.service.MissionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/mission")
@ResponseBody
public class MissionController {

    @Resource
    private MissionService missionService;

    @RequestMapping("/saveMission")
    public RetResult<Object> saveUser(@RequestBody Mission mission){
        missionService.saveMission(mission);
        return RetResponse.makeOKRsp();
    }

    @RequestMapping(value = "/getMission")
    public RetResult<Mission> getUser(@RequestParam(value = "missionId") Long missionId){
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
}
