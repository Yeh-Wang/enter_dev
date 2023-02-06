package com.yeh.pro.mapper;

import com.yeh.pro.entity.TrainingResourceEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
public interface TrainingResourceMapper extends BaseMapper<TrainingResourceEntity> {

    /**
     * 通过计划编号查询所有的资源
     */
    @Select("select * from training_resource where plan_id = #{planId}")
    List<TrainingResourceEntity> getAllByPlanId(@Param("planId") Integer planId);

    @Update("update training_resource set choose_question_id = null where plan_id=#{planId} and choose_question_id =#{resId};")
    Integer deleteChooseByPlanId(@Param("planId") Integer planId,@Param("resId") Integer resId);
    @Update("update training_resource set judge_question_id = null where plan_id=#{planId} and judge_question_id =#{resId};")
    Integer deleteJudgeByPlanId(@Param("planId") Integer planId,@Param("resId") Integer resId);
    @Update("update training_resource set video_resource_id = null where plan_id=#{planId} and video_resource_id =#{resId};")
    Integer deleteVideoByPlanId(@Param("planId") Integer planId,@Param("resId") Integer resId);

    @Select("select count(choose_question_id) from training_resource where plan_id = #{planId} and choose_question_id = #{id}")
    int isOneChoose(@Param("planId") Integer planId,@Param("id") Integer id);
    @Select("select count(judge_question_id) from training_resource where plan_id = #{planId} and judge_question_id = #{id}")
    int isOneJudge(@Param("planId") Integer planId,@Param("id") Integer id);
    @Select("select count(video_resource_id) from training_resource where plan_id = #{planId} and video_resource_id = #{id}")
    int isOneVideo(@Param("planId") Integer planId,@Param("id") Integer id);
}
