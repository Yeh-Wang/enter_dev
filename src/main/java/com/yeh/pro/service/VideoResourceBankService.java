package com.yeh.pro.service;

import com.yeh.pro.entity.JudgeQuestionBankEntity;
import com.yeh.pro.entity.VideoResourceBankEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:16
 */
public interface VideoResourceBankService extends IService<VideoResourceBankEntity> {

    /**
     * 根据视频编号查询视频信息
     */
    VideoResourceBankEntity getVideoInfoById(Integer video_id);

    /**
     * 根据创建者查询视频信息
     */
    List<VideoResourceBankEntity> getVideoByFounder(Integer founder);

    /**
     * 选择所有视频资源信息
     */
    List<VideoResourceBankEntity> getAllVideoInfo();

    /**
     * 增加一个视频信息
     */
    Integer addVideoInfo(VideoResourceBankEntity videoResourceBankEntity);

    /**
     * 删除一个视频信息
     */
    Integer deleteVideoInfo(Integer id);

    /**
     * 更改一个视频信息
     */
    Integer updateVideoInfo(VideoResourceBankEntity videoResourceBankEntity);

    /**
     * get the max id
     */
    Integer getMaxId();
}
