package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
//import java.time.LocalTime;
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
 * @since 2023-01-30 22:32:16
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("video_resource_bank")
//@ApiModel(value = "VideoResourceBankEntity对象", description = "")
public class VideoResourceBankEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("founder")
    private Integer founder;

    @TableField("video_name")
    private String videoName;

    @TableField("video_type")
    private String videoType;

    @TableField("video_url")
    private String videoUrl;

    @TableField("video_total_time")
    private String videoTotalTime;


}
