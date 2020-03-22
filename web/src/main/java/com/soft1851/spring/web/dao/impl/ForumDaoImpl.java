package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.ForumDao;
import com.soft1851.spring.web.entity.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/21 11:08
 * @Description:
 */
@Repository
public class ForumDaoImpl  implements ForumDao {

    private  JdbcTemplate jdbcTemplate;

    public ForumDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Forum> selectAll() {
        String sql = "SELECT * FROM t_forum ";
        System.out.println(jdbcTemplate);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Forum.class));
    }

    @Override
    public int insert(Forum forum) {
        String sql = "INSERT INTO t_forum VALUES (Null,?)";
        Object[] args = {forum.getForumName()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public int[] batchInsert(List<Forum> forums) {
        String sql = "INSERT INTO t_forum VALUES (NULL,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setString(1,forums.get(i).getForumName());
            }

            @Override
            public int getBatchSize() {
                return forums.size();
            }
        });
    }

    @Override
    public int delete(int forumId) {
        String sql = "DELETE  FROM t_forum WHERE forum_id = ?";
        Object args = forumId;
        return jdbcTemplate.update(sql,args);
    }

    /**
     * 修改forum中的字段值
     * @param forum
     * @return
     */
    @Override
    public int update(Forum forum) {
        String sql = "UPDATE t_forum SET forum_name = ? WHERE forum_id = ?";
        Object[] args = {forum.getForumName(), forum.getForumId()};
        return jdbcTemplate.update(sql, args);
    }

    @Override
    public Forum get(int forumId) {
        String sql = " SELECT * FROM t_forum WHERE forum_id = ? ";
        Object[] args = {forumId};
        return jdbcTemplate.queryForObject(sql, args,new BeanPropertyRowMapper<>(Forum.class));
    }


}
