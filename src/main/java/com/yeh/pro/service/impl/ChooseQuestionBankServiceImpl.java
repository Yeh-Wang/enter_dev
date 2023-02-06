package com.yeh.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yeh.pro.entity.ChooseQuestionBankEntity;
import com.yeh.pro.entity.UsersInfoEntity;
import com.yeh.pro.mapper.ChooseQuestionBankMapper;
import com.yeh.pro.service.ChooseQuestionBankService;
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
public class ChooseQuestionBankServiceImpl extends ServiceImpl<ChooseQuestionBankMapper, ChooseQuestionBankEntity> implements ChooseQuestionBankService {

    private ChooseQuestionBankMapper chooseQuestionBankMapper;

    @Autowired
    public void setChooseQuestionBankMapper(ChooseQuestionBankMapper chooseQuestionBankMapper){
        this.chooseQuestionBankMapper=chooseQuestionBankMapper;
    }

    @Override
    public ChooseQuestionBankEntity getChooseInfoById(Integer choose_id) {
        return chooseQuestionBankMapper.selectById(choose_id);
    }

    @Override
    public List<ChooseQuestionBankEntity> getAllChooseInfo() {
        return chooseQuestionBankMapper.selectList(null);
    }

    @Override
    public Integer addChooseInfo(ChooseQuestionBankEntity chooseQuestionBankEntity) {
        Integer choose_id = chooseQuestionBankMapper.selectOne(new QueryWrapper<ChooseQuestionBankEntity>().select("max(id) as id")).getId()+1;
        chooseQuestionBankEntity.setId(choose_id);
        return chooseQuestionBankMapper.insert(chooseQuestionBankEntity);
    }

    @Override
    public Integer deleteChooseInfo(Integer id) {
        return chooseQuestionBankMapper.deleteById(id);
    }

    @Override
    public Integer updateChooseInfo(ChooseQuestionBankEntity chooseQuestionBankEntity) {
        return chooseQuestionBankMapper.updateById(chooseQuestionBankEntity);
    }
}
