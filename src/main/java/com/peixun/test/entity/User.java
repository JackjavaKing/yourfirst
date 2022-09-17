package com.peixun.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Date;

//用户表bean
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
    @NotEmpty(message = "邮箱不能为空")
    @Email(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "邮箱格式错误")
    @TableField(value = "account_num")
    private String accountNum;

    //密码
    @NotEmpty(message = "密码不能为空")
    @Pattern(regexp = "^[a-zA-Z]\\w{5,17}$", message = "密码以字母开头，长度在6~18之间，只能包含字母、数字和下划线")
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
