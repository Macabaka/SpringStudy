package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumServiceTest {
    @Autowired
    private  ForumService forumService;

    @Test
    public void selectAll() {
        System.out.println(forumService.selectAll());
    }

    @Test
    public void insert() {
        System.out.println(forumService.insert(Forum.builder().forumName("123123").build()));
    }

    @Test
    public void batchInsert() {
        System.out.println(forumService.batchInsert(Arrays.asList(new Forum[]{Forum.builder().forumName("123123").build(), Forum.builder().forumName("123123").build()})));
    }

    @Test
    public void delete() {
        System.out.println(forumService.delete(20));
    }

    @Test
    public void update() {
        System.out.println(forumService.update(Forum.builder().forumName("硬件").forumId(28).build()));
    }

    @Test
    public void get() {
        System.out.println(forumService.get(28));
    }

    @Test
    public void testInsert() {
    }
}