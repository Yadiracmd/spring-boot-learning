package com.ztf.login.template.entity.vo;


import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class LoginInfo {



    private String phone;
    private String password;
    private String code;

}
