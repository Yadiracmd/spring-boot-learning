package com.ztf.boot.database.dao;


import com.ztf.boot.database.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaDAO extends JpaRepository<Article,Integer> {

}
