package com.yeh.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeh.pro.entity.*;
import com.yeh.pro.mapper.ChooseQuestionBankMapper;
import com.yeh.pro.mapper.JudgeQuestionBankMapper;
import com.yeh.pro.mapper.TrainingResourceMapper;
import com.yeh.pro.mapper.VideoResourceBankMapper;
import com.yeh.pro.service.TrainingResourceService;
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
 * @since 2023-01-30 22:32:15
 */
@Service
public class TrainingResourceServiceImpl extends ServiceImpl<TrainingResourceMapper, TrainingResourceEntity> implements TrainingResourceService {

    private TrainingResourceMapper trainingResourceMapper;
    private ChooseQuestionBankMapper chooseQuestionBankMapper;
    private JudgeQuestionBankMapper judgeQuestionBankMapper;
    private VideoResourceBankMapper videoResourceBankMapper;

    @Autowired
    public void setTrainingResourceMapper(TrainingResourceMapper trainingResourceMapper){
        this.trainingResourceMapper=trainingResourceMapper;
    }
    @Autowired
    public void setChooseQuestionBankMapper(ChooseQuestionBankMapper chooseQuestionBankMapper){
        this.chooseQuestionBankMapper=chooseQuestionBankMapper;
    }
    @Autowired
    public void setJudgeQuestionBankMapper(JudgeQuestionBankMapper judgeQuestionBankMapper){
        this.judgeQuestionBankMapper=judgeQuestionBankMapper;
    }
    @Autowired
    public void setVideoResourceBankMapper(VideoResourceBankMapper videoResourceBankMapper){
        this.videoResourceBankMapper=videoResourceBankMapper;
    }


    @Override
    public List<TrainingResourceEntity> getAllByPlanId(Integer planId) {
        return trainingResourceMapper.getAllByPlanId(planId);
    }

    @Override
    public Integer deleteOneByPlanId(Integer planId, Integer resId, Integer resType) {
        if(resType==1){
            return trainingResourceMapper.deleteChooseByPlanId(planId,resId);
        }else if(resType==2){
            return trainingResourceMapper.deleteJudgeByPlanId(planId,resId);
        }else{
            return trainingResourceMapper.deleteVideoByPlanId(planId,resId);
        }
    }

    @Override
    public Integer saveChooseResourceInfo(Integer planId,List<ChooseQuestionBankEntity> list) {
        for(int i=0;i<list.size();i++){
            Integer readyId = list.get(i).getId();
            if(trainingResourceMapper.isOneChoose(planId,readyId)!=1){
                Integer id = trainingResourceMapper.selectOne(new QueryWrapper<TrainingResourceEntity>().select("max(id) as id")).getId()+1;
                TrainingResourceEntity trainingResourceEntity = new TrainingResourceEntity();
                trainingResourceEntity.setId(id);
                trainingResourceEntity.setChooseQuestionId(readyId);
                trainingResourceEntity.setPlanId(planId);
                trainingResourceMapper.insert(trainingResourceEntity);
            }
        }
        return 1;
    }

    @Override
    public Integer saveJudgeResourceInfo(Integer planId,List<JudgeQuestionBankEntity> list) {
        for(int i=0;i<list.size();i++){
            Integer readyId = list.get(i).getId();
            if(trainingResourceMapper.isOneJudge(planId,readyId)!=1){
                Integer id = trainingResourceMapper.selectOne(new QueryWrapper<TrainingResourceEntity>().select("max(id) as id")).getId()+1;
                TrainingResourceEntity trainingResourceEntity = new TrainingResourceEntity();
                trainingResourceEntity.setId(id);
                trainingResourceEntity.setJudgeQuestionId(readyId);
                trainingResourceEntity.setPlanId(planId);
                trainingResourceMapper.insert(trainingResourceEntity);
            }
        }
        return 1;
    }

    @Override
    public Integer saveVideoResourceInfo(Integer planId,List<VideoResourceBankEntity> list) {
        for(int i=0;i<list.size();i++){
            Integer readyId = list.get(i).getId();
            if(trainingResourceMapper.isOneVideo(planId,readyId)!=1){
                Integer id = trainingResourceMapper.selectOne(new QueryWrapper<TrainingResourceEntity>().select("max(id) as id")).getId()+1;
                TrainingResourceEntity trainingResourceEntity = new TrainingResourceEntity();
                trainingResourceEntity.setId(id);
                trainingResourceEntity.setVideoResourceId(readyId);
                trainingResourceEntity.setPlanId(planId);
                trainingResourceMapper.insert(trainingResourceEntity);
            }
        }
        return 1;
    }
}
