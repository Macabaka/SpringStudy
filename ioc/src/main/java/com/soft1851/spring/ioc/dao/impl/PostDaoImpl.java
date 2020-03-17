package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.PostDao;
import com.soft1851.spring.ioc.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author dyf
 */
@Repository
public class PostDaoImpl implements PostDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 单独插入post
     * @param post
     * @return
     */
    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post (forum_id,title,content,thumbnail,post_time) VALUES (?,?,?,?,?)";
        Object[] args = {post.getForumId(),post.getTitle(),post.getContent(),post.getThumbnail(),post.getPostTime()};
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 批量插入post
     * @param posts
     * @return
     */
    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post (forum_id,title,content,thumbnail,post_time) VALUES (?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, String.valueOf(postList.get(i).getForumId()));
                preparedStatement.setString(2,postList.get(i).getTitle());
                preparedStatement.setString(3,postList.get(i).getContent());
                preparedStatement.setString(4, String.valueOf(postList.get(i).getThumbnail()));
                preparedStatement.setString(5, String.valueOf(postList.get(i).getPostTime()));
            }

            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    /**
     * 删除post
     * @param postId
     * @return 影响行数
     */
    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 上传post
     * @param post
     * @return 影响行数
     */
    @Override
    public int update(Post post) {
        String sql = "UPDATE t_post SET title = ? WHERE post_id = ?";
        Object[] args = {post.getTitle(),post.getTitle()};
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 根据id查询post
     * @param postId
     * @return
     */
    @Override
    public Post get(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Post.class));
    }

    /**
     * 查询全部post
     * @return
     */
    @Override
    public List<Post> selectAll() {
        String sql = "SELECT * FROM t_Post ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public int[] batchDelete(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1, String.valueOf(postList.get(i).getPostId()));
            }
            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public List<Post> selectByKey(String key) {
        String sql = "SELECT * FROM t_Post  WHERE title LIKE  ? ";
        Object[] args = {key};
        return jdbcTemplate.query(sql, args,new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> getCountByForum(int id) {
        String sql = "select count(*) from t_post where forum_id= ? ";
        Object[] args = {id};
        return jdbcTemplate.query(sql,args, new BeanPropertyRowMapper<>(Post.class));
    }

}
