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
@TableName("learn_space")
//@ApiModel(value = "LearnSpaceEntity对象", description = "")
public class LearnSpaceEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("train_id")
    private Integer trainId;

    @TableField("user_id")
    private Integer userId;

    @TableField("video_id")
    private Integer videoId;

    @TableField("video_breakpoint")
    private String videoBreakpoint;

    @TableField("plan_status")
    private Boolean planStatus;


}
