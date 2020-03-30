package com.soft1851.springmvc.web.dao;

import com.soft1851.springmvc.web.config.SpringDataSourceConfig;
import com.soft1851.springmvc.web.entity.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class TopicDaoTest {
    @Autowired
    private TopicDao  topicDao;
    @Test
    public void selectAll() {
        System.out.println(topicDao.selectAll());
    }

    @Test
    public void batchInsert() {
        List<Topic> topicList = new ArrayList<>(){
            {
                this.add(Topic.builder().id("3").topicIcon("123").description("123123").topicName("12312").followed(true).followersCount(123).msgCount(123).build());
                this.add(Topic.builder().id("4").topicIcon("123").description("123123").topicName("12312").followed(true).followersCount(123).msgCount(123).build());
                this.add(Topic.builder().id("5").topicIcon("123").description("123123").topicName("12312").followed(true).followersCount(123).msgCount(123).build());
            }
        };
        assertEquals(3,topicDao.batchInsert(topicList).length);
    }

    @Test
    public void insert() {
        Topic topic = Topic.builder().id("2").topicIcon("123").description("123123").topicName("12312").followed(true).followersCount(123).msgCount(123).build();
        assertEquals(1,topicDao.insert(topic));
    }
}