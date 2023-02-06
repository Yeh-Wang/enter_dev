package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
//import java.time.LocalDateTime;
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
@TableName("training_parameter")
//@ApiModel(value = "TrainingParameterEntity对象", description = "")
public class TrainingParameterEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("founder")
    private Integer founder;

    @TableField("mechanism_id")
    private Integer mechanismId;

    @TableField("train_introduce")
    private String trainIntroduce;

    @TableField("train_type")
    private String trainType;

    @TableField("train_period")
    private Float trainPeriod;

    @TableField("start_time")
    private String startTime;

    @TableField("end_time")
    private String endTime;

    @TableField("train_status")
    private String trainStatus;


}
