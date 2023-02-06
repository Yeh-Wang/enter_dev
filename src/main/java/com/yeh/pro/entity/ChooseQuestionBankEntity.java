package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("choose_question_bank")
//@ApiModel(value = "ChooseQuestionBankEntity对象", description = "")
public class ChooseQuestionBankEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("founder")
    private Integer founder;

    @TableField("`type`")
    private String type;

    @TableField("question")
    private String question;

    @TableField("answer_a")
    private String answerA;

    @TableField("answer_b")
    private String answerB;

    @TableField("answer_c")
    private String answerC;

    @TableField("answer_d")
    private String answerD;

    @TableField("answer_correct")
    private String answerCorrect;

    @TableField("analysis")
    private String analysis;

    @TableField("score")
    private Integer score;
}
