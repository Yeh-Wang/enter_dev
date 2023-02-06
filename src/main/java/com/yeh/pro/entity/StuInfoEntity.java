package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author : Yaxin-Wang
 * @date : 2023/2/6
 */
@Getter
@Setter
@Data
@Accessors(chain = true)
@TableName("stu_info")
public class StuInfoEntity {
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField("user_grade")
    private Integer userGrade;

    @TableField("user_mechanism")
    private Integer userMechanism;

    @TableField("real_name")
    private String realName;

    @TableField("is_complete")
    private String isComplete;

    @TableField("exam_paper_id")
    private Integer examPaperId;

    @TableField("score")
    private Integer score;

    @TableField("video_id")
    private Integer videoId;

    @TableField("video_breakpoint")
    private String videoBreakpoint;

    @TableField("plan_status")
    private String planStatus;
}
