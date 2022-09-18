package com.peixun.test.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.Date;

//blog表bean
@Data
public class Blog {

    //主键
    @TableId(value = "id")
    private int id;

    //用户id
    @TableField(value = "user_id")
    private int userId;

    //blog标题

    @Pattern(regexp = "^.{1,256}$",message = "最大256字符,不能有空格")
    @TableField(value = "title")
    private String title;


    @TableField(value = "content")
    private String content;

    //创建时间
    @TableField(value = "create_time")
    private Date createTime;

    //更改时间
    @TableField(value = "update_time")
    private Date updateTime;

    //逻辑删除
    @TableLogic(value = "is_deleted")
    private int isDeleted;

}
