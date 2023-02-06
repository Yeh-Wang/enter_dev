package com.yeh.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yeh.pro.entity.StuInfoEntity;
import com.yeh.pro.mapper.StuInfoMapper;
import com.yeh.pro.service.StuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Yaxin-Wang
 * @date : 2023/2/6
 */
@Service
public class StuInfoServiceImpl extends ServiceImpl<StuInfoMapper, StuInfoEntity> implements StuInfoService {

    private StuInfoMapper stuInfoMapper;
    @Autowired
    public void setStuInfoMapper(StuInfoMapper stuInfoMapper){
        this.stuInfoMapper=stuInfoMapper;
    }

    @Override
    public List<StuInfoEntity> getUsersAllInfoByOrgId(int mechanism_id, int user_grade) {
        return stuInfoMapper.getUsersAllInfoByOrgId(mechanism_id,user_grade);
    }
}
