package com.yeh.pro.controller;

import com.yeh.pro.entity.ChooseQuestionBankEntity;
import com.yeh.pro.service.ChooseQuestionBankService;
import com.yeh.pro.service.impl.ChooseQuestionBankServiceImpl;
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
@RequestMapping("/choose-question-bank-entity")
public class ChooseQuestionBankController {

    private ChooseQuestionBankServiceImpl chooseQuestionBankService;

    @Autowired
    public void setChooseQuestionBankService(ChooseQuestionBankServiceImpl chooseQuestionBankService){
        this.chooseQuestionBankService=chooseQuestionBankService;
    }

    /**
     * 选择所有选择题信息
     */
    @ResponseBody
    @GetMapping("/getAllChooseInfo")
    List<ChooseQuestionBankEntity> getAllChooseInfo(){
        return chooseQuestionBankService.getAllChooseInfo();
    }

    /**
     * 增加一个选择题信息
     */
    @ResponseBody
    @RequestMapping("/addChooseInfo")
    Integer addChooseInfo(@RequestBody ChooseQuestionBankEntity chooseQuestionBankEntity) {
        return chooseQuestionBankService.addChooseInfo(chooseQuestionBankEntity);
    }

    /**
     * 删除一个选择题信息
     */
    @ResponseBody
    @GetMapping("/deleteChooseInfo/{id}")
    Integer deleteChooseInfo(@PathVariable Integer id) {
        return chooseQuestionBankService.deleteChooseInfo(id);
    }

    /**
     * 更改一个选择题信息
     */
    @ResponseBody
    @RequestMapping("/updateChooseInfo")
    Integer updateChooseInfo(@RequestBody ChooseQuestionBankEntity chooseQuestionBankEntity) {
        return chooseQuestionBankService.updateChooseInfo(chooseQuestionBankEntity);
    }
}
