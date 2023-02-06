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
@TableName("users_info")
//@ApiModel(value = "UsersInfoEntity对象", description = "")
public class UsersInfoEntity {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    @TableField("user_grade")
    private Integer userGrade;

    @TableField("user_mechanism")
    private Integer userMechanism;

    @TableField("real_name")
    private String realName;

    @TableField("user_name")
    private String userName;

    @TableField("user_pwd")
    private String userPwd;

    @TableField("user_sexy")
    private String userSexy;

    @TableField("user_age")
    private Integer userAge;

    @TableField("user_phone")
    private String userPhone;

    @TableField("user_address")
    private String userAddress;
}
