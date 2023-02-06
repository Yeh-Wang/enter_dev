package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalTime;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author YehWang
 * @since 2023-01-30 22:32:15
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("exam_paper_bank")
//@ApiModel(value = "ExamPaperBankEntity对象", description = "")
public class ExamPaperBankEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("plan_id")
    private Integer planId;

    @TableField("exam_subject")
    private String examSubject;

    @TableField("question_number")
    private Integer questionNumber;

    @TableField("choose_question_number")
    private Integer chooseQuestionNumber;

    @TableField("judge_question_number")
    private Integer judgeQuestionNumber;

    @TableField("start_time")
    private String startTime;

    @TableField("end_time")
    private String endTime;


}
