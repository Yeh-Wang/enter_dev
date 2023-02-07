package com.yeh.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeh.pro.entity.VideoResourceBankEntity;
import com.yeh.pro.mapper.VideoResourceBankMapper;
import com.yeh.pro.service.VideoResourceBankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:16
 */
@Service
public class VideoResourceBankServiceImpl extends ServiceImpl<VideoResourceBankMapper, VideoResourceBankEntity> implements VideoResourceBankService {

    private VideoResourceBankMapper videoResourceBankMapper;

    @Autowired
    public void setVideoResourceBankMapper(VideoResourceBankMapper videoResourceBankMapper){
        this.videoResourceBankMapper=videoResourceBankMapper;
    }

    @Override
    public VideoResourceBankEntity getVideoInfoById(Integer video_id) {
        return videoResourceBankMapper.getVideoById(video_id);
    }

    @Override
    public List<VideoResourceBankEntity> getVideoByFounder(Integer founder) {
        return videoResourceBankMapper.getVideoByFounder(founder);
    }

    @Override
    public List<VideoResourceBankEntity> getAllVideoInfo() {
        return videoResourceBankMapper.selectList(null);
    }

    @Override
    public Integer addVideoInfo(VideoResourceBankEntity videoResourceBankEntity) {
        return videoResourceBankMapper.insert(videoResourceBankEntity);
    }

    @Override
    public Integer deleteVideoInfo(Integer id) {
        return videoResourceBankMapper.deleteById(id);
    }

    @Override
    public Integer updateVideoInfo(VideoResourceBankEntity videoResourceBankEntity) {
        return null;
    }

    @Override
    public Integer getMaxId() {
        if(videoResourceBankMapper.selectOne(new QueryWrapper<VideoResourceBankEntity>().select("max(id) as id")).getId()==null){
            return 0;
        }else{
            return videoResourceBankMapper.selectOne(new QueryWrapper<VideoResourceBankEntity>().select("max(id) as id")).getId();
        }
    }
}
