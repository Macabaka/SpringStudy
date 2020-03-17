package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {
    @Autowired
    private PostDao postDao;
    @Test
    public void insert() {
        Timestamp date = new Timestamp(199123129);
        Post post = Post.builder().forumId(1).title("测试1").content("123").thumbnail(new byte[123]).postTime(date).build();
        int n = postDao.insert(post);
        assertEquals(1,n);
    }

    @Test
    public void batchInsert() {
        Timestamp date = new Timestamp(199123129);
        Post[] posts = {Post.builder().forumId(1).title("测试1").content("123").thumbnail(new byte[123]).postTime(date).build(),
                Post.builder().forumId(2).title("测试2").content("123").thumbnail(new byte[123]).postTime(date).build(),
                Post.builder().forumId(2).title("测试3").content("123").thumbnail(new byte[123]).postTime(date).build()
        };
        List<Post> PostList = Arrays.asList(posts);
        int[] rows = postDao.batchInsert(PostList);
        assertEquals(3,rows.length);
    }

    @Test
    public void delete() {
        int n = postDao.delete(1);
        assertEquals(1,n);
    }

    @Test
    public void update() {
        Post post = postDao.get(1);
        post.setTitle("测试论坛修改的新名称");
        System.out.println(post.getTitle());
    }

    @Test
    public void get() {
        Post post = postDao.get(1);
        assertNotNull(post);
    }

    @Test
    public void selectAll() {
        List<Post> posts = postDao.selectAll();
//        assertEquals(8,posts.size());
        System.out.println(posts);
    }

    @Test
    public void batchDelete() {
        Timestamp date = new Timestamp(199123129);
        Post[] posts = {
                Post.builder().forumId(1).postId(7).build(),
                Post.builder().forumId(1).postId(8).build(),
                Post.builder().forumId(1).postId(9).build()
        };
        List<Post> PostList = Arrays.asList(posts);
        int[] rows = postDao.batchDelete(PostList);
        assertEquals(3,rows.length);
    }

    @Test
    public void getCountByForum() {
        List<Post> post = postDao.getCountByForum(1);
        assertNotNull(post);
    }

    @Test
    public void selectByKey() {
        List<Post> post = postDao.selectByKey("王");
        assertNotNull(post);
    }
}