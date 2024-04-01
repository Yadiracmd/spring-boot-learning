package com.ztf.boot.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("user")
@Data
// 链式开启为true
@Accessors(chain = true)
public class UserDO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("gender")
    private String gender;

    @TableField("phone")
    private String phone;

    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


    /*
    * 逻辑删除标记： 1 删除 0 未删除
    * */
    @TableField("deleted")
    private Integer deleted;
}
