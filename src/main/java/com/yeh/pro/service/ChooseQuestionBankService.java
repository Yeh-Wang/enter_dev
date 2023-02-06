package com.yeh.pro.service;

import com.yeh.pro.entity.ChooseQuestionBankEntity;
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
public interface ChooseQuestionBankService extends IService<ChooseQuestionBankEntity> {

    /**
     * 根据选择题编号查询选择题信息
     */
    ChooseQuestionBankEntity getChooseInfoById(Integer choose_id);

    /**
     * 选择所有选择题信息
     */
    List<ChooseQuestionBankEntity> getAllChooseInfo();

    /**
     * 增加一个选择题信息
     */
    Integer addChooseInfo(ChooseQuestionBankEntity chooseQuestionBankEntity);

    /**
     * 删除一个选择题信息
     */
    Integer deleteChooseInfo(Integer id);

    /**
     * 更改一个选择题信息
     */
    Integer updateChooseInfo(ChooseQuestionBankEntity chooseQuestionBankEntity);
}
