package com.peixun.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    //主键
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    //名字
    @TableField(value = "username")
    private String username;

    //性别
    @TableField(value = "gender")
    private int gender;

    //账号
    @TableField(value = "account_num")
    private String accountNum;

    //密码
    @TableField(value = "account_password")
    private String accountPassword;

    //创建人
    @TableField(value = "create_by")
    private String createBy;

    //更改人
    @TableField(value = "update_by")
    private String updateBy;

    //创建时间
    @TableField(value = "create_time")
    private Date createTime;

    //更改时间
    @TableField(value = "update_time")
    private Date updateTime;

    //是否删除
    @TableField(value = "is_deleted")
    private int isDeleted;
}
