package com.yeh.pro.mapper;

import com.yeh.pro.entity.UsersInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@Mapper
public interface UsersInfoMapper extends BaseMapper<UsersInfoEntity> {

    /**
     * 验证账号
     */
    @Select("select 1 from users_info where user_name = #{name} limit 1")
    String judgeUsername(@Param("name") String name);

    /**
     * 验证密码
     */
    @Select("select 1 from users_info where user_pwd = #{password} limit 1")
    String judgeUserPwd(@Param("password") String password);

    /**
     * 验证用户等级
     */
    @Select("select COUNT(*) from users_info where user_grade = #{grade} and user_pwd = #{password} and user_name = #{name}")
    int judgeUserGrade(@Param("grade") int grade, @Param("name") String name, @Param("password") String password);

    /**
     * 根据id查找用户信息
     */
    @Select("select * from users_info where user_id = #{id}")
    UsersInfoEntity getUserInfoById(@Param("id") int id);

    /**
     * 获取id
     */
    @Select("select user_id from users_info where user_grade = #{grade} and user_pwd = #{password} and user_name = #{name}")
    int getId(@Param("grade") int grade, @Param("name") String name, @Param("password") String password);

    /**
     * 根据机构编号找到属于该机构的所有用户信息
     */
    @Select("select * from users_info where user_mechanism = #{mechanism_id} and user_grade = #{user_grade}")
    List<UsersInfoEntity> getUsersInfoByOrgId(@Param("mechanism_id") int mechanism_id,@Param("user_grade") int user_grade);
}
