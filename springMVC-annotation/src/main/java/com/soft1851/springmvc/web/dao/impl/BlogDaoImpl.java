package com.soft1851.springmvc.web.dao.impl;

import com.soft1851.springmvc.web.dao.BlogDao;
import com.soft1851.springmvc.web.entity.Blog;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 01:50
 * @Description:
 */
@Repository
public class BlogDaoImpl implements BlogDao {

    @Resource
    JdbcTemplate jdbcTemplate;


    @Override
    public int[] batchInsert(List<Blog> blogs) {
        final List<Blog> blogList = blogs;
        String sql = " INSERT INTO t_blog(title,description,author,author_avatar) VALUES (?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Blog blog = blogList.get(i);
                preparedStatement.setString(1,blog.getTitle());
                preparedStatement.setString(2, blog.getDescription());
                preparedStatement.setString(3, blog.getAuthor());
                preparedStatement.setString(4, blog.getAuthorAvatar());
            }

            @Override
            public int getBatchSize() {
                return blogList.size();
            }
        });
    }

    @Override
    public List<Blog> selectAll() {
        String sql ="SELECT * FROM t_blog";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Blog.class));
    }
}
