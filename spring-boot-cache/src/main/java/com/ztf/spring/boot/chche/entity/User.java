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
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = -7635550537775194841L;

    private String id;
    private String name;
    private Address address;

}
