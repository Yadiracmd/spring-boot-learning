package com.ztf.boot.database.mapper;

import com.ztf.boot.database.entity.Article;

import java.util.List;

public interface ArticleMapper {
    void insertArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(int id);

    List<Article> findAll();

    void deleteArticle(int id);
}
