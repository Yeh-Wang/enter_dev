package com.yeh.pro.controller;

import com.yeh.pro.entity.ChooseQuestionBankEntity;
import com.yeh.pro.entity.JudgeQuestionBankEntity;
import com.yeh.pro.service.impl.ChooseQuestionBankServiceImpl;
import com.yeh.pro.service.impl.JudgeQuestionBankServiceImpl;
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
@RequestMapping("/judge-question-bank-entity")
public class JudgeQuestionBankController {

    private JudgeQuestionBankServiceImpl judgeQuestionBankService;

    @Autowired
    public void setChooseQuestionBankService(JudgeQuestionBankServiceImpl judgeQuestionBankService){
        this.judgeQuestionBankService=judgeQuestionBankService;
    }

    /**
     * 选择所有判断题信息
     */
    @ResponseBody
    @GetMapping("/getAllJudgeInfo")
    List<JudgeQuestionBankEntity> getAllJudgeInfo(){
        return judgeQuestionBankService.getAllJudgeInfo();
    }

    /**
     * 增加一个判断题信息
     */
    @ResponseBody
    @RequestMapping("/addJudgeInfo")
    Integer addJudgeInfo(@RequestBody JudgeQuestionBankEntity judgeQuestionBankEntity) {
        return judgeQuestionBankService.addJudgeInfo(judgeQuestionBankEntity);
    }

    /**
     * 删除一个判断题信息
     */
    @ResponseBody
    @GetMapping("/deleteJudgeInfo/{id}")
    Integer deleteJudgeInfo(@PathVariable Integer id) {
        return judgeQuestionBankService.deleteJudgeInfo(id);
    }

    /**
     * 更改一个判断题信息
     */
    @ResponseBody
    @RequestMapping("/updateJudgeInfo")
    Integer updateJudgeInfo(@RequestBody JudgeQuestionBankEntity judgeQuestionBankEntity) {
        return judgeQuestionBankService.updateJudgeInfo(judgeQuestionBankEntity);
    }
}
