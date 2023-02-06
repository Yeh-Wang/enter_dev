package com.yeh.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
//import io.swagger.annotations.ApiModel;
//import io.swagger.models.auth.In;
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
@TableName("organization_info")
//@ApiModel(value = "organizationInfo对象", description = "")
public class organizationInfo {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    @TableField("org_name")
    String orgName;
    @TableField("org_type")
    String orgType;
    @TableField("description")
    String description;
    @TableField("display_content")
    String displayContent;
}
