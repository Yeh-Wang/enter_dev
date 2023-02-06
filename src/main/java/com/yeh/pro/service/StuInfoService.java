package com.yeh.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yeh.pro.entity.StuInfoEntity;
import com.yeh.pro.entity.UsersInfoEntity;

import java.util.List;

/**
 * @author : Yaxin-Wang
 * @date : 2023/2/6
 */
public interface StuInfoService extends IService<StuInfoEntity> {

    /**
     * 根据机构编号找到属于该机构的所有用户所有信息
     */
    List<StuInfoEntity> getUsersAllInfoByOrgId(int mechanism_id, int user_grade);
}
