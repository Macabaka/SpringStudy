package com.soft1851.springmvc.web.dao.impl;

import com.soft1851.springmvc.web.dao.TopicDao;
import com.soft1851.springmvc.web.entity.Topic;
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
 * @Date: 2020/3/26 10:07
 * @Description:
 */
@Repository
public class TopicDaoImpl implements TopicDao {
    //        如果使用final继续定义的话，则需要有一个构造方法为变量定义初始值
    //    扩展：关键字final详解
    //    1、当用final去修饰一个类的时候，表示这个类不能被继承
    //    2、被final修饰的方法不能被重写
    //    3、final修饰成员变量时，必须为这个成员变量赋初始值，而且是只能初始化一次
    //    4、final修饰（基本数据类型）成员变量时，表示这个变量的值不能改变
    //    5、final修饰（引用数据类型）成员变量时，表示这个引用的地址的值不能修改，但是这个引用所指向的对象里卖弄的内容还是可以改变的
    @Resource
    private   JdbcTemplate jdbcTemplate;


    @Override
    public List<Topic> selectAll() {
        String sql = "SELECT * FROM t_topic";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Topic.class));
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        final List<Topic> topicList = topics;
        String sql ="INSERT INTO t_topic(id,topic_name,topic_icon,description,followers_count,msg_count,followed) " +
                "VALUES (?,?,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Topic topic =topicList.get(i);
                preparedStatement.setString(1,topic.getId());
                preparedStatement.setString(2, topic.getTopicName());
                preparedStatement.setString(3,topic.getTopicIcon());
                preparedStatement.setString(4, topic.getDescription());
                preparedStatement.setInt(5,topic.getMsgCount());
                preparedStatement.setInt(6,topic.getFollowersCount());
                preparedStatement.setBoolean(7,topic.getFollowed());
            }

            @Override
            public int getBatchSize() {
                return topicList.size();
            }
        });
    }
    //    org.springframework.dao.DuplicateKeyException:报错信息：跟主键冲突

    @Override
    public int insert(Topic topic) {
        String sql ="INSERT INTO t_topic(id,topic_name,topic_icon,description,followers_count,msg_count,followed) " +
                "VALUES (?,?,?,?,?,?,?)";
        Object[] params = {topic.getId(), topic.getTopicName(), topic.getTopicIcon(), topic.getDescription(),
                topic.getFollowersCount(), topic.getMsgCount(), topic.getFollowed()};
        return jdbcTemplate.update(sql, params);
    }
}
