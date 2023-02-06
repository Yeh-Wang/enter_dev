package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("judge_question_bank")
//@ApiModel(value = "JudgeQuestionBankEntity对象", description = "")
public class JudgeQuestionBankEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("founder")
    private Integer founder;

    @TableField("`type`")
    private String type;

    @TableField("question")
    private String question;

    @TableField("answer_correct")
    private String answerCorrect;

    @TableField("analysis")
    private String analysis;

    @TableField("score")
    private Integer score;

}
