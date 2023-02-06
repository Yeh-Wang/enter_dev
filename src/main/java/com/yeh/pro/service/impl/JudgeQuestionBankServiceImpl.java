package com.yeh.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeh.pro.entity.JudgeQuestionBankEntity;
import com.yeh.pro.entity.UsersInfoEntity;
import com.yeh.pro.mapper.JudgeQuestionBankMapper;
import com.yeh.pro.service.JudgeQuestionBankService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@Service
public class JudgeQuestionBankServiceImpl extends ServiceImpl<JudgeQuestionBankMapper, JudgeQuestionBankEntity> implements JudgeQuestionBankService {

    private JudgeQuestionBankMapper judgeQuestionBankMapper;

    @Autowired
    public void setJudgeQuestionBankMapper(JudgeQuestionBankMapper judgeQuestionBankMapper){
        this.judgeQuestionBankMapper=judgeQuestionBankMapper;
    }

    @Override
    public JudgeQuestionBankEntity getJudgeInfoById(Integer judge_id) {
        return judgeQuestionBankMapper.selectById(judge_id);
    }

    @Override
    public List<JudgeQuestionBankEntity> getAllJudgeInfo() {
        return judgeQuestionBankMapper.selectList(null);
    }

    @Override
    public Integer addJudgeInfo(JudgeQuestionBankEntity judgeQuestionBankEntity) {
        Integer judge_id = judgeQuestionBankMapper.selectOne(new QueryWrapper<JudgeQuestionBankEntity>().select("max(id) as id")).getId()+1;
        judgeQuestionBankEntity.setId(judge_id);
        return judgeQuestionBankMapper.insert(judgeQuestionBankEntity);
    }

    @Override
    public Integer deleteJudgeInfo(Integer id) {
        return judgeQuestionBankMapper.deleteById(id);
    }

    @Override
    public Integer updateJudgeInfo(JudgeQuestionBankEntity judgeQuestionBankEntity) {
        return judgeQuestionBankMapper.updateById(judgeQuestionBankEntity);
    }
}
