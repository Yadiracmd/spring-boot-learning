package com.ztf.boot.database.service;

import com.ztf.boot.database.entity.Article;

import java.util.List;

public interface ArticleJpaService {

    void saveArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(int id);

    List<Article> findAll();

    void deleteArticle(int id);

}
