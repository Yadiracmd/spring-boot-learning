package com.ztf.boot.database.mapper;

import com.ztf.boot.database.entity.Article;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Slf4j
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void insertArticle() {
        Article article = Article.builder().author("ztf").title("spring boot").content("Spring Boot").build();
        articleMapper.insertArticle(article);
    }


    @Test
    void updateArticle() {
        Article article = Article.builder().author("周添峰").title("spring boot").content("Spring Boot").id(1).build();
        articleMapper.updateArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleMapper.getArticleById(1);
        log.info(String.valueOf(article));
    }

    @Test
    void findAll() {
        List<Article> articleList = articleMapper.findAll();
        log.info(articleList.toString());
    }

    @Test
    void deleteArticle() {
        articleMapper.deleteArticle(1);
    }
}