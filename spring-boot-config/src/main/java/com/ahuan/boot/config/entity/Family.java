package com.ahuan.boot.config.entity;

import jakarta.validation.Valid;
import lombok.Data;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@Component
@PropertySource(value = {"classpath:family.properties"})
@ConfigurationProperties(prefix = "family")
@Valid
public class Family {

    @Length(min = 5, max = 20, message = "家庭名长度必须位于5到20之间")
    private String familyName;

    private String father;

    private String mother;

    private String child;

    @Range(min = 3, message = "必须大于3年！")
    private Integer years;
}
