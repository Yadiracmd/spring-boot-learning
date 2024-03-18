package com.ztf.boot.database.dao;

import com.ztf.boot.database.entity.Article;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class ArticleJDBCDAOTest {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Test
    void save() {
        Article article = Article.builder().author("ztf").title("spring boot").content("Spring Boot").build();
        int n = articleJDBCDAO.save(article);
        log.info(String.valueOf(n));
    }

}