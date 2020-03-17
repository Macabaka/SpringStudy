package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;

import java.util.List;

/**
 * @author dyf
 */
public interface ForumDao {
    /**
     *
     * @param forum
     * @return
     */
    int insert(Forum forum);

    /**
     *
     * @param forums
     * @return
     */
    int[] batchInsert(List<Forum> forums);

    /**
     *
     * @param forumId
     * @return
     */
    int delete(int forumId);

    /**
     *
     * @param forum
     * @return
     */
    int update(Forum forum);

    /**
     *
     * @param forumId
     * @return
     */
    Forum get(int forumId);

    /**
     *
     * @return
     */
    List<Forum> selectAll();
}
