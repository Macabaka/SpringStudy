package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;


public interface ForumDao {
    /**
     * 查询
     * @return
     */
    List<Forum> selectAll();

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
}
