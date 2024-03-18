package com.ztf.boot.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // * 必要要的
@Table(name = "t_article") // 可选的，指定数据库名称
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 32)
    private String author;

    @Column(nullable = false, length = 32)
    private String title;

    @Column(nullable = false, length = 500)
    private String content;
}
