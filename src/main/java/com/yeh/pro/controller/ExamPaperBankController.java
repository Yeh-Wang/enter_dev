package com.yeh.pro.controller;

import com.yeh.pro.entity.ExamPaperBankEntity;
import com.yeh.pro.service.impl.ExamPaperBankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@RestController
@RequestMapping("/exam-paper-bank-entity")
public class ExamPaperBankController {

    ExamPaperBankServiceImpl examPaperBankService;

    @Autowired
    public void setExamPaperBankService(ExamPaperBankServiceImpl examPaperBankService){
        this.examPaperBankService=examPaperBankService;
    }

    /**
     * 根据计划编号获取对应考试信息
     */
    @ResponseBody
    @GetMapping("/getExamByPlanId/{planId}")
    ExamPaperBankEntity getExamByPlanId(@PathVariable Integer planId){
        return examPaperBankService.getExamByPlanId(planId);
    }

    /**
     * 更新一条考试信息
     */
    @ResponseBody
    @PostMapping("/updateExamInfo")
    Integer updateExamInfo(@RequestBody ExamPaperBankEntity examPaperBankEntity){
        return examPaperBankService.updateExamInfo(examPaperBankEntity);
    }
}
