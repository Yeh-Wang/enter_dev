package com.yeh.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeh.pro.entity.ExamPaperBankEntity;
import com.yeh.pro.entity.TrainingParameterEntity;
import com.yeh.pro.mapper.ExamPaperBankMapper;
import com.yeh.pro.mapper.TrainingParameterMapper;
import com.yeh.pro.mapper.UsersInfoMapper;
import com.yeh.pro.service.TrainingParameterService;
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
public class TrainingParameterServiceImpl extends ServiceImpl<TrainingParameterMapper, TrainingParameterEntity> implements TrainingParameterService {

    private TrainingParameterMapper trainingParameterMapper;
    private ExamPaperBankMapper examPaperBankMapper;

    @Autowired
    public void setTrainingParameterMapper(TrainingParameterMapper trainingParameterMapper){
        this.trainingParameterMapper=trainingParameterMapper;
    }
    @Autowired
    public void setExamPaperBankMapper(ExamPaperBankMapper examPaperBankMapper){
        this.examPaperBankMapper=examPaperBankMapper;
    }

    @Override
    public List<TrainingParameterEntity> getAllByMechanismId(Integer id) {
        return trainingParameterMapper.getAllByMechanismId(id);
    }

    @Override
    public Integer addTrainPlan(TrainingParameterEntity trainingParameterEntity) {
        Integer train_id = trainingParameterMapper.selectOne(new QueryWrapper<TrainingParameterEntity>().select("max(id) as id")).getId()+1;
        trainingParameterEntity.setId(train_id);
        trainingParameterMapper.insert(trainingParameterEntity);
        Integer exam_id = examPaperBankMapper.selectOne(new QueryWrapper<ExamPaperBankEntity>().select("max(id) as id")).getId()+1;
        ExamPaperBankEntity examPaperBankEntity = new ExamPaperBankEntity();
        examPaperBankEntity.setId(exam_id);
        examPaperBankEntity.setPlanId(train_id);
        examPaperBankEntity.setQuestionNumber(0);
        examPaperBankEntity.setChooseQuestionNumber(0);
        examPaperBankEntity.setJudgeQuestionNumber(0);
        examPaperBankEntity.setStartTime("2000-05-25 00:00:00");
        examPaperBankEntity.setEndTime("2000-05-25 00:00:00");
        return examPaperBankMapper.insert(examPaperBankEntity);
    }

    @Override
    public Integer deleteTrainPlan(Integer id) {
        return trainingParameterMapper.deleteById(id);
    }

    @Override
    public Integer updateTrainPlan(TrainingParameterEntity trainingParameterEntity) {
        return trainingParameterMapper.updateById(trainingParameterEntity);
    }

    @Override
    public TrainingParameterEntity getOneByPlanId(Integer id) {
        return trainingParameterMapper.selectById(id);
    }
}
