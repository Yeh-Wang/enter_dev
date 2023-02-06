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
@TableName("audit_info")
//@ApiModel(value = "AuditInfoEntity对象", description = "")
public class AuditInfoEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("content")
    private String content;

    @TableField("submitter")
    private String submitter;

    @TableField("auditor")
    private String auditor;

    @TableField("audit_status")
    private Boolean auditStatus;

}
