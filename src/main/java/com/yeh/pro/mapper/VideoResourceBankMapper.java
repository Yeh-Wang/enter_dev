package com.yeh.pro.mapper;

import com.yeh.pro.entity.VideoResourceBankEntity;
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
 * @since 2023-01-30 22:32:16
 */
@Mapper
public interface VideoResourceBankMapper extends BaseMapper<VideoResourceBankEntity> {

    @Select("select * from video_resource_bank where id = #{id}")
    VideoResourceBankEntity getVideoById(@Param("id") Integer id);

    @Select("select * from video_resource_bank where founder = #{founder}")
    List<VideoResourceBankEntity> getVideoByFounder(@Param("founder") Integer founder);
}
