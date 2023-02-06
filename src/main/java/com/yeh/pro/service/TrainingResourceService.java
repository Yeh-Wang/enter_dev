package com.yeh.pro.service;

import com.yeh.pro.entity.ChooseQuestionBankEntity;
import com.yeh.pro.entity.JudgeQuestionBankEntity;
import com.yeh.pro.entity.TrainingResourceEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yeh.pro.entity.VideoResourceBankEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
public interface TrainingResourceService extends IService<TrainingResourceEntity> {

    /**
     * 通过计划编号查询所有的资源
     */
    List<TrainingResourceEntity> getAllByPlanId(Integer planId);

    /**
     * 删除制定计划的一个指定资源
     */
    Integer deleteOneByPlanId(Integer planId,Integer resId,Integer resType);

    /**
     * 保存前端传回的资源信息，选择试题编号
     */
    Integer saveChooseResourceInfo(Integer planId,List<ChooseQuestionBankEntity> list);
    /**
     * 保存前端传回的资源信息，判断试题编号
     */
    Integer saveJudgeResourceInfo(Integer planId,List<JudgeQuestionBankEntity> list);
    /**
     * 保存前端传回的资源信息，视频编号
     */
    Integer saveVideoResourceInfo(Integer planId,List<VideoResourceBankEntity> list);
}
