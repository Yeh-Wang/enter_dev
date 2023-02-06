package com.yeh.pro.service;

import com.yeh.pro.entity.ExamPaperBankEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
public interface ExamPaperBankService extends IService<ExamPaperBankEntity> {

    /**
     * 根据计划编号获取对应考试信息
     */
    ExamPaperBankEntity getExamByPlanId(Integer planId);

    /**
     * 更新一条考试信息
     */
    Integer updateExamInfo(ExamPaperBankEntity examPaperBankEntity);
}
