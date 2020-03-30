package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ForumServiceTest {
    @Resource
    private ForumService   forumService;

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("3.30测试").build();
        forumService.insert(forum);
    }

    @Test
    public void delete() {
    }

    @Test
    public void update() {
    }

    @Test
    public void selectAll() {
        forumService.selectAll();
    }

    @Test
    public void selectForumById() {
    }
}