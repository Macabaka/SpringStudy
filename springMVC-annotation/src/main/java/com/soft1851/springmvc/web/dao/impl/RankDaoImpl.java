package com.soft1851.springmvc.web.dao.impl;

import com.soft1851.springmvc.web.dao.RankDao;
import com.soft1851.springmvc.web.entity.Rank;
import com.soft1851.springmvc.web.entity.Topic;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 00:18
 * @Description:
 */
@Repository
public class RankDaoImpl implements RankDao {
    @Resource
    private JdbcTemplate jdbcTemplate;


    @Override
    public int[] batchInsert(List<Rank> ranks) {
        final  List<Rank> rankList = ranks;
        String sql ="INSERT INTO t_rank(pic,title,author,duration) VALUES (?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Rank rank = rankList.get(i);
                preparedStatement.setString(1, rank.getPic());
                preparedStatement.setString(2,rank.getTitle());
                preparedStatement.setString(3,rank.getAuthor());
                preparedStatement.setString(4,rank.getDuration());
            }
            @Override
            public int getBatchSize() {
                return rankList.size();
            }
        });
    }

    @Override
    public int insert(Rank rank) {
//        String sql = ""
        return 0;
    }

}
