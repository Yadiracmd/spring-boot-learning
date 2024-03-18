package com.ztf.boot.database.dao;


import com.ztf.boot.database.entity.Article;
import jakarta.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // 数据持久层
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /*
    * 新增文章
    * @param article 文章对象
    * */
    public int save(Article article){
        String sql = "INSERT INTO t_article(author,title,content) values(?,?,?)";
        return jdbcTemplate.update(sql,article.getAuthor(),article.getTitle(),article.getContent());
    }

    public int updateById(Article article){
        return jdbcTemplate.update("update t_article set author = ?,title = ?,content = ? where id=?",article.getAuthor(),article.getTitle(),article.getContent(),article.getId());
    }

    public Article findById(Long id){
        // queryForObject 用于查询
        return jdbcTemplate.queryForObject("select * from t_article where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
    }

    /*
    * 查询所有文章
    * */
}
