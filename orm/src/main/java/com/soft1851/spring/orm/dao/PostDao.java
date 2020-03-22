package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Post;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/19 17:39
 * @Description:
 */
public interface PostDao {
    /**
     *
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     *
     * @param posts
     * @return
     */
    int[] batchInsert(List<Post> posts);

    /**
     *
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     *
     * @param post
     * @return
     */
    int update(Post post);

    /**
     *
     * @param postId
     * @return
     */
    Post get(int postId);

    /**
     *
     * @return
     */
    List<Post> selectAll();

    /**
     *
     * @param posts
     * @return
     */
    int[] batchDelete(List<Post> posts);

    /**
     *
     * @param key
     * @return
     */
    List<Post> selectByKey(String key);

    List<Post> getCountByForum(int id);
}
