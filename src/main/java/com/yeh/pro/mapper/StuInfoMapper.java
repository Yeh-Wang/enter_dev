package com.yeh.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yeh.pro.entity.StuInfoEntity;
import com.yeh.pro.entity.UsersInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : Yaxin-Wang
 * @date : 2023/2/6
 */
@Mapper
public interface StuInfoMapper extends BaseMapper<StuInfoEntity> {


    /**
     * 根据机构编号找到属于该机构的所有用户所有信息
     */
    @Select("select * from stu_info where user_mechanism = #{mechanism_id} and user_grade = #{user_grade}")
    List<StuInfoEntity> getUsersAllInfoByOrgId(@Param("mechanism_id") int mechanism_id, @Param("user_grade") int user_grade);
}
