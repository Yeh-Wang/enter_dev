package com.yeh.pro.mapper;

import com.yeh.pro.entity.ExamPaperBankEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@Mapper
public interface ExamPaperBankMapper extends BaseMapper<ExamPaperBankEntity> {

    /**
     * 根据计划编号获取对应考试信息
     */
    @Select("select * from exam_paper_bank where plan_id = #{planId}")
    ExamPaperBankEntity getExamByPlanId(@Param("planId") Integer planId);

    /**
     * 设置选择试题数量
     */
    @Update("update exam_paper_bank set choose_question_number = #{chooseNumber} where plan_id = #{planId}")
    void setChooseNumber(@Param("chooseNumber") Integer chooseNumber,@Param("planId") Integer planId);
    /**
     * 设置判断试题数量
     */
    @Update("update exam_paper_bank set judge_question_number = #{judgeNumber} where plan_id = #{planId}")
    void setJudgeNumber(@Param("judgeNumber") Integer judgeNumber,@Param("planId") Integer planId);
    /**
     * 设置试题数量
     */
    @Update("update exam_paper_bank set question_number = #{questionNumber} where plan_id = #{planId}")
    void setQuestionNumber(@Param("questionNumber") Integer questionNumber,@Param("planId") Integer planId);
}
