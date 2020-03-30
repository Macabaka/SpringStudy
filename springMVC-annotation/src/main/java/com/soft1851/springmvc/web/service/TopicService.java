package com.soft1851.springmvc.web.service;

import com.soft1851.springmvc.web.entity.Topic;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/28 17:05
 * @Description:
 */
public interface TopicService {
    /**
     * 查询所有topic
     * @return
     */
    List<Topic> queryAll();


    /**
     * 批量增加topic
     * @param topics
     * @return
     */
    int[] batchInsert(List<Topic> topics);


    /**
     * 新增topic
     * @param topic
     */
    void addTopic(Topic topic);
}
