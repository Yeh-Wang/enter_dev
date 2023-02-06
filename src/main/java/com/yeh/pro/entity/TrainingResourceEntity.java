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
@TableName("training_resource")
//@ApiModel(value = "TrainingResourceEntity对象", description = "")
public class TrainingResourceEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("plan_id")
    private Integer planId;

    @TableField("choose_question_id")
    private Integer chooseQuestionId;

    @TableField("judge_question_id")
    private Integer judgeQuestionId;

    @TableField("video_resource_id")
    private Integer videoResourceId;


}
