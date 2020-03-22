package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumDaoTest {
    @Autowired
    private  ForumDao forumDao;
    @Test
    public void selectAll() {
        List<Forum> list = forumDao.selectAll();
        System.out.println(list);
    }

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("wewe").build();
        int row = forumDao.insert(forum);
        assertEquals(1,row);
    }

    @Test
    public void batchInsert() {
        Forum[] forums = {
                Forum.builder().forumName("历史").build(),
                Forum.builder().forumName("生物").build(),
                Forum.builder().forumName("计算机").build()
        };
        List<Forum> forumList = Arrays.asList(forums);
        assertEquals(3,forumDao.batchInsert(forumList).length);
    }

    @Test
    public void delete() {
        int row = forumDao.delete(3);
        assertEquals(1,row);
    }

    @Test
    public void update() {
        Forum forum = Forum.builder().forumId(15).forumName("计算机").build();
        assertEquals(1,forumDao.update(forum));
    }

    @Test
    public void get() {
        Forum forum = forumDao.get(18);
        assertNotNull(forum);
    }
}