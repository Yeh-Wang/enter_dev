package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author : Yaxin-Wang
 * @date : 2023/2/1
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("display_list")
@ApiModel(value = "DisplayListEntity对象", description = "")
public class DisplayListEntity {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    @TableField("mechanism_id")
    Integer mechanismId;
    @TableField("content")
    String content;
}
