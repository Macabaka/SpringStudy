package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.entity.Forum;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/19 17:39
 * @Description:
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
