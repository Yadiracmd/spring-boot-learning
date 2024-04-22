package com.ztf.spring.boot.chche.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address implements Serializable {

    @Serial
    private static final long serialVersionUID = -2486829832486423213L;

    private String province;
    private String city;
}
