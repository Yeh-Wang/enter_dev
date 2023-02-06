package com.yeh.pro.service;

import com.yeh.pro.entity.ChooseQuestionBankEntity;
import com.yeh.pro.entity.JudgeQuestionBankEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
public interface JudgeQuestionBankService extends IService<JudgeQuestionBankEntity> {

    /**
     * 根据判断题编号查询判断题信息
     */
    JudgeQuestionBankEntity getJudgeInfoById(Integer judge_id);

    /**
     * 选择所有判断题信息
     */
    List<JudgeQuestionBankEntity> getAllJudgeInfo();

    /**
     * 增加一个判断题信息
     */
    Integer addJudgeInfo(JudgeQuestionBankEntity judgeQuestionBankEntity);

    /**
     * 删除一个判断题信息
     */
    Integer deleteJudgeInfo(Integer id);

    /**
     * 更改一个判断题信息
     */
    Integer updateJudgeInfo(JudgeQuestionBankEntity judgeQuestionBankEntity);
}
