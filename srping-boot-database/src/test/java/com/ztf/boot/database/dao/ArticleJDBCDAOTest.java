package com.ztf.boot.database.dao;

import com.ztf.boot.database.entity.Article;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void updateById() {
        Article article = Article.builder().author("ztf111-").title("spring boot").content("Spring Boot").id(2).build();
        int n = articleJDBCDAO.updateById(article);
        log.info(String.valueOf(n));
    }

    @Test
    void findById() {
        Article article = articleJDBCDAO.findById(2L);
        log.error("找到的文章" + article);
    }

    @Test
    void findAll() {
        List<Article> all = articleJDBCDAO.findAll();
        log.error("文章大全" + all);
    }

    @Test
    void deleteById() {
        int id = articleJDBCDAO.deleteById(3L);
        log.info("删除成功"+id);
    }
}