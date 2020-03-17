package com.soft1851.spring.ioc.dao.impl;

import com.soft1851.spring.ioc.dao.ForumDao;
import com.soft1851.spring.ioc.entity.Forum;
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
public class ForumDaoImpl implements ForumDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 单独插入forum
     * @param forum
     * @return
     */
    @Override
    public int insert(Forum forum) {
        String sql = "INSERT INTO t_forum VALUES (NULL,?)";
        Object[] args = {forum.getForumName()};
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 批量插入forums
     * @param forums
     * @return
     */
    @Override
    public int[] batchInsert(List<Forum> forums) {
        final List<Forum> forumList = forums;
        String sql = "INSERT INTO t_forum VALUES (NULL,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,forumList.get(i).getForumName());
            }
            @Override
            public int getBatchSize() {
                return forumList.size();
            }
        });
    }

    /**
     * 删除forum
     * @param forumId
     * @return
     */
    @Override
    public int delete(int forumId) {
        String sql = "DELETE FROM t_forum WHERE forum_id = ?";
        Object[] args = {forumId};
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 上传forum
     * @param forum
     * @return
     */
    @Override
    public int update(Forum forum) {
        String sql = "UPDATE t_forum SET forum_name = ? WHERE forum_id = ?";
        Object[] args = {forum.getForumName(),forum.getForumId()};
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 根据id查询forum
     * @param forumId
     * @return
     */
    @Override
    public Forum get(int forumId) {
        String sql = "SELECT * FROM t_forum WHERE forum_id = ?";
        Object[] args = {forumId};
        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Forum.class));
    }

    /**
     * 查询所有forum
     * @return
     */
    @Override
    public List<Forum> selectAll() {
        String sql = "SELECT * FROM t_forum ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Forum.class));
    }
}
