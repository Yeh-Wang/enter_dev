package com.yeh.pro.mapper;

import com.yeh.pro.entity.TrainingParameterEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@Mapper
public interface TrainingParameterMapper extends BaseMapper<TrainingParameterEntity> {

    /**
     * get all training plans information
     */
    @Select("select * from training_parameter where mechanism_id = #{id}")
    List<TrainingParameterEntity> getAllByMechanismId(@Param("id") Integer id);
}
