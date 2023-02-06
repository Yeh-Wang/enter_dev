package com.yeh.pro.service;

import com.yeh.pro.entity.TrainingParameterEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
public interface TrainingParameterService extends IService<TrainingParameterEntity> {
    /**
     * get all training plans information
     */
    List<TrainingParameterEntity> getAllByMechanismId(Integer id);

    /**
     * add a training plan
     */
    Integer addTrainPlan(TrainingParameterEntity trainingParameterEntity);

    /**
     * delete a training plan
     */
    Integer deleteTrainPlan(Integer id);

    /**
     * update a training plan
     */
    Integer updateTrainPlan(TrainingParameterEntity trainingParameterEntity);

    /**
     * select a plan info by plan id
     */
    TrainingParameterEntity getOneByPlanId(Integer id);
}
