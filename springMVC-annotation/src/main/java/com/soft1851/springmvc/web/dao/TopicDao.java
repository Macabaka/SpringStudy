package com.soft1851.springmvc.web.dao;

import com.soft1851.springmvc.web.entity.Topic;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/26 10:06
 * @Description:
 */
public interface TopicDao {
    List<Topic> selectAll();

    /**
     * 批量插入
     * @param topics
     * @return
     */
    int[] batchInsert(List<Topic> topics);


    /**
     * 新增一个
     * @param topic
     * @return
     */
    int insert(Topic topic);
}
