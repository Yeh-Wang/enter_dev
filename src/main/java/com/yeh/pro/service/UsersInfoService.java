package com.yeh.pro.service;

import com.yeh.pro.entity.UsersInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
public interface UsersInfoService extends IService<UsersInfoEntity> {

    /**
     * 验证账号
     */
    String judgeUsername(String name);

    /**
     * 验证密码
     */
    String judgeUserPwd(String password);

    /**
     * 验证用户等级
     */
    String judgeUserGrade(int grade,String username,String password);

    /**
     * 根据id查找用户信息
     */
    UsersInfoEntity getUserInfoById(int id);

    /**
     * 获取id
     */
    int getId(int grade,String username,String password);

    /**
     * 根据机构编号找到属于该机构的所有用户基本信息
     */
    List<UsersInfoEntity> getUsersInfoByOrgId(int mechanism_id, int user_grade);

    /**
     * 添加一个用户
     */
    Integer addUserInfo(UsersInfoEntity usersInfoEntity);

    /**
     * 更新一个用户信息
     */
    int updateUserInfo(UsersInfoEntity usersInfoEntity);

    /**
     * 删除一个用户信息
     */
    int deleteUserInfo(Integer id);
}
