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
@TableName("exam_info")
//@ApiModel(value = "ExamInfoEntity对象", description = "")
public class ExamInfoEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("exam_paper_id")
    private Integer examPaperId;

    @TableField("score")
    private Integer score;

    @TableField("is_complete")
    private String isComplete;
}
