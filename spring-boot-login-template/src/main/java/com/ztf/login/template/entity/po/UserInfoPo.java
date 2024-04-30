package com.ztf.login.template.entity.po;


import lombok.Data;

@Data
public class UserInfoPo {
    private Integer id;
    private String name;
    private String avatar;
    // 性别 1男 2女
    private Integer sex;
    private String token;
    private String phone;

}
