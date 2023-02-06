package com.yeh.pro.controller;

import com.yeh.pro.entity.ChooseQuestionBankEntity;
import com.yeh.pro.entity.JudgeQuestionBankEntity;
import com.yeh.pro.entity.TrainingResourceEntity;
import com.yeh.pro.entity.VideoResourceBankEntity;
import com.yeh.pro.mapper.ExamPaperBankMapper;
import com.yeh.pro.service.impl.ChooseQuestionBankServiceImpl;
import com.yeh.pro.service.impl.JudgeQuestionBankServiceImpl;
import com.yeh.pro.service.impl.TrainingResourceServiceImpl;
import com.yeh.pro.service.impl.VideoResourceBankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@RestController
@RequestMapping("/training-resource-entity")
public class TrainingResourceController {

    private TrainingResourceServiceImpl trainingResourceService;
    private VideoResourceBankServiceImpl videoResourceBankService;
    private ChooseQuestionBankServiceImpl chooseQuestionBankService;
    private JudgeQuestionBankServiceImpl judgeQuestionBankService;
    private ExamPaperBankMapper examPaperBankMapper;

    @Autowired
    public void setTrainingResourceService(TrainingResourceServiceImpl trainingResourceService){
        this.trainingResourceService=trainingResourceService;
    }
    @Autowired
    public void setVideoResourceBankService(VideoResourceBankServiceImpl videoResourceBankService){
        this.videoResourceBankService=videoResourceBankService;
    }
    @Autowired
    public void setChooseQuestionBankService(ChooseQuestionBankServiceImpl chooseQuestionBankService){
        this.chooseQuestionBankService=chooseQuestionBankService;
    }
    @Autowired
    public void setJudgeQuestionBankService(JudgeQuestionBankServiceImpl judgeQuestionBankService){
        this.judgeQuestionBankService=judgeQuestionBankService;
    }
    @Autowired
    public void setExamPaperBankMapper(ExamPaperBankMapper examPaperBankMapper){
        this.examPaperBankMapper=examPaperBankMapper;
    }

    /**
     * 根据计划编号获取所有的视频资源
     */
    @ResponseBody
    @GetMapping("/getVideoByPlanId/{id}")
    List<VideoResourceBankEntity> getVideoByPlanId(@PathVariable Integer id){
        List<TrainingResourceEntity> list = trainingResourceService.getAllByPlanId(id);
        List<VideoResourceBankEntity> list_1 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getVideoResourceId()!=null){
                VideoResourceBankEntity videoResourceBankEntity = videoResourceBankService.getVideoInfoById(list.get(i).getVideoResourceId());
                list_1.add(videoResourceBankEntity);
            }
        }
        return list_1;
    }

    /**
     * 根据计划编号获取所有的选择题资源
     */
    @ResponseBody
    @GetMapping("/getChooseByPlanId/{id}")
    List<ChooseQuestionBankEntity> getChooseByPlanId(@PathVariable Integer id){
        List<TrainingResourceEntity> list = trainingResourceService.getAllByPlanId(id);
        List<ChooseQuestionBankEntity> list_1 = new ArrayList<>();
        Integer chooseNumber = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getChooseQuestionId()!=null){
                ChooseQuestionBankEntity chooseQuestionBankEntity = chooseQuestionBankService.getChooseInfoById(list.get(i).getChooseQuestionId());
                list_1.add(chooseQuestionBankEntity);
                chooseNumber++;
            }
        }
        examPaperBankMapper.setChooseNumber(chooseNumber, id);
        return list_1;
    }

    /**
     * 根据计划编号获取所有的判断题资源
     */
    @ResponseBody
    @GetMapping("/getJudgeByPlanId/{id}")
    List<JudgeQuestionBankEntity> getJudgeByPlanId(@PathVariable Integer id){
        List<TrainingResourceEntity> list = trainingResourceService.getAllByPlanId(id);
        List<JudgeQuestionBankEntity> list_1 = new ArrayList<>();
        Integer judgeNumber = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i).getJudgeQuestionId()!=null){
                JudgeQuestionBankEntity judgeQuestionBankEntity = judgeQuestionBankService.getJudgeInfoById(list.get(i).getJudgeQuestionId());
                list_1.add(judgeQuestionBankEntity);
                judgeNumber++;
            }
        }
        examPaperBankMapper.setJudgeNumber(judgeNumber, id);
        return list_1;
    }

    /**
     * 删除制定计划的一个指定资源
     */
    @ResponseBody
    @GetMapping("/deleteOneByPlanId/{planId},{resId},{resType}")
    public Integer deleteOneByPlanId(@PathVariable Integer planId, @PathVariable Integer resId, @PathVariable Integer resType){
        return trainingResourceService.deleteOneByPlanId(planId, resId, resType);
    }

    /**
     * 保存前端传回的资源信息，选择试题编号
     */
    @ResponseBody
    @RequestMapping("/saveChooseResourceInfo/{planId}")
    public Integer saveChooseResourceInfo(@PathVariable Integer planId,@RequestBody List<ChooseQuestionBankEntity> list){
        return trainingResourceService.saveChooseResourceInfo(planId,list);
    }
    /**
     * 保存前端传回的资源信息，判断试题编号
     */
    @ResponseBody
    @RequestMapping("/saveJudgeResourceInfo/{planId}")
    public Integer saveJudgeResourceInfo(@PathVariable Integer planId,@RequestBody List<JudgeQuestionBankEntity> list){
        return trainingResourceService.saveJudgeResourceInfo(planId, list);
    }
    /**
     * 保存前端传回的资源信息，视频编号
     */
    @ResponseBody
    @RequestMapping("/saveVideoResourceInfo/{planId}")
    public Integer saveVideoResourceInfo(@PathVariable Integer planId,@RequestBody List<VideoResourceBankEntity> list){
        return trainingResourceService.saveVideoResourceInfo(planId, list);
    }
}
