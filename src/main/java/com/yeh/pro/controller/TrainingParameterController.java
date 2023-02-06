package com.yeh.pro.controller;

import com.yeh.pro.entity.TrainingParameterEntity;
import com.yeh.pro.service.impl.TrainingParameterServiceImpl;
import com.yeh.pro.service.impl.UsersInfoServiceImpl;
//import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/training-parameter-entity")
public class TrainingParameterController {

    TrainingParameterServiceImpl trainingParameterService;

    @Autowired
    public void setTrainingParameterService(TrainingParameterServiceImpl trainingParameterService) {
        this.trainingParameterService = trainingParameterService;
    }

    /**
     * get all training plans information
     */
    @ResponseBody
    @GetMapping("/getAllByMechanismId/{id}")
    List<TrainingParameterEntity> getAllByMechanismId(@PathVariable Integer id){
        return trainingParameterService.getAllByMechanismId(id);
    }

    /**
     * add a training plan
     */
    @ResponseBody
    @PostMapping("/addTrainPlan")
    Integer addTrainPlan(@RequestBody TrainingParameterEntity trainingParameterEntity){
        return trainingParameterService.addTrainPlan(trainingParameterEntity);
    }

    /**
     * delete a training plan
     */
    @ResponseBody
    @GetMapping("/deleteTrainPlan/{id}")
    Integer deleteTrainPlan(@PathVariable Integer id){
        return trainingParameterService.deleteTrainPlan(id);
    }

    /**
     * update a training plan
     */
    @ResponseBody
    @PostMapping("/updateTrainPlan")
    Integer updateTrainPlan(@RequestBody TrainingParameterEntity trainingParameterEntity){
        return trainingParameterService.updateTrainPlan(trainingParameterEntity);
    }

    /**
     * select a plan info by plan id
     */
    @ResponseBody
    @GetMapping("/getOneByPlanId/{id}")
    public TrainingParameterEntity getOneByPlanId(@PathVariable Integer id){
        return trainingParameterService.getOneByPlanId(id);
    }
}
