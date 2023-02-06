package com.yeh.pro.service.impl;

import com.yeh.pro.entity.ExamPaperBankEntity;
import com.yeh.pro.mapper.ExamPaperBankMapper;
import com.yeh.pro.service.ExamPaperBankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@Service
public class ExamPaperBankServiceImpl extends ServiceImpl<ExamPaperBankMapper, ExamPaperBankEntity> implements ExamPaperBankService {

    private ExamPaperBankMapper examPaperBankMapper;

    @Autowired
    public void setExamPaperBankMapper(ExamPaperBankMapper examPaperBankMapper) {
        this.examPaperBankMapper = examPaperBankMapper;
    }

    /**
     * 根据计划编号获取对应考试信息
     */
    public ExamPaperBankEntity getExamByPlanId(Integer planId) {

        return examPaperBankMapper.getExamByPlanId(planId);
    }

    @Override
    public Integer updateExamInfo(ExamPaperBankEntity examPaperBankEntity) {
        return examPaperBankMapper.updateById(examPaperBankEntity);
    }
}
