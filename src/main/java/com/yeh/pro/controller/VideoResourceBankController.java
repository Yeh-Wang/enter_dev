package com.yeh.pro.controller;

import com.yeh.pro.entity.UsersInfoEntity;
import com.yeh.pro.entity.VideoResourceBankEntity;
import com.yeh.pro.service.impl.UsersInfoServiceImpl;
import com.yeh.pro.service.impl.VideoResourceBankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ws.schild.jave.EncoderException;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.info.MultimediaInfo;

import java.io.File;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:16
 */
@RestController
@RequestMapping("/video-resource-bank-entity")
public class VideoResourceBankController {

    private VideoResourceBankServiceImpl videoResourceBankService;
    private UsersInfoServiceImpl usersInfoService;

    @Autowired
    public void setVideoResourceBankService(VideoResourceBankServiceImpl videoResourceBankService) {
        this.videoResourceBankService = videoResourceBankService;
    }
    @Autowired
    public void setUsersInfoService(UsersInfoServiceImpl usersInfoService){
        this.usersInfoService=usersInfoService;
    }

    /**
     * 选择所有视频资源信息
     */
    @ResponseBody
    @GetMapping("/getAllVideoInfo")
    List<VideoResourceBankEntity> getAllVideoInfo() {
        return videoResourceBankService.getAllVideoInfo();
    }

    /**
     * 增加一个视频信息
     */
    @ResponseBody
    @RequestMapping("/addVideoInfo")
    Integer addVideoInfo(@RequestBody VideoResourceBankEntity videoResourceBankEntity) {
        return videoResourceBankService.addVideoInfo(videoResourceBankEntity);
    }

    /**
     * 增加多个视频信息
     */
    @ResponseBody
    @RequestMapping("/addSomeVideoInfo/{founderId}")
    Integer addSomeVideoInfo(@PathVariable Integer founderId, @RequestBody String[] list) {
        for (int i = 0; i < list.length; i++) {
            VideoResourceBankEntity videoResourceBankEntity = new VideoResourceBankEntity();
            videoResourceBankEntity.setVideoName(list[i]);
            videoResourceBankEntity.setVideoUrl("http://localhost:9090/yeh/" + list[i]);
            videoResourceBankEntity.setFounder(founderId);
            Integer videoId = videoResourceBankService.getMaxId() + 1;
            videoResourceBankEntity.setId(videoId);
            String time = getVideoTime(new File("D:/looker/Video/" + list[i]));
            videoResourceBankEntity.setVideoTotalTime(time);
            videoResourceBankService.addVideoInfo(videoResourceBankEntity);
        }
        return 1;
    }

    /**
     * 获取视频长度
     */
    public String getVideoTime(File file) {
        try {
            MultimediaObject instance = new MultimediaObject(file);
            MultimediaInfo result = instance.getInfo();
            int m = 0;
            int s = (int) (result.getDuration() / 1000);
            String time = "00:";
            while (s > 60) {
                s = s - 60;
                m++;
            }
            if (m < 10) {
                if (s < 10) {
                    time = time + "0" + m + ":0" + s;
                } else {
                    time = time + "0" + m + ":" + s;
                }
            }else{
                time = time + m + ":" + s;
            }
            return time;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "00:00:00";
    }

    /**
     * 获取超级管理员和指定机构的所有视频
     */
    @ResponseBody
    @GetMapping("/getAllVideoByOrgId/{org_id}")
    List<VideoResourceBankEntity> getAllVideoByOrgId(@PathVariable Integer org_id){
        List<UsersInfoEntity> list_1 = usersInfoService.getUsersInfoByOrgId(org_id,1);
        List<VideoResourceBankEntity> list_2 = videoResourceBankService.getVideoByFounder(1);
        for(int i=0 ;i< list_1.size();i++){
            List<VideoResourceBankEntity> list = videoResourceBankService.getVideoByFounder(list_1.get(i).getUserId());
            list_2.addAll(list);
            list.clear();
        }
        return list_2;
    }

    /**
     * 删除一个视频信息
     */
    @ResponseBody
    @GetMapping("/deleteVideoInfo/{id}")
    Integer deleteVideoInfo(@PathVariable Integer id) {
        return videoResourceBankService.deleteVideoInfo(id);
    }

    /**
     * 更改一个视频信息
     */
    @ResponseBody
    @RequestMapping("/updateVideoInfo")
    Integer updateVideoInfo(@RequestBody VideoResourceBankEntity videoResourceBankEntity) {
        return videoResourceBankService.updateVideoInfo(videoResourceBankEntity);
    }
}
