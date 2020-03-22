package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.util.ResponseObject;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/21 11:05
 * @Description:
 */
public interface ForumService {
    /**
     * 查询所有论坛
     * @return
     */
    ResponseObject selectAll();

    /**
     * 插入单个论坛
     * @return
     */
    ResponseObject insert(Forum forum);

    /**
     * 批量插入论坛
     * @param forums
     * @return
     */
    ResponseObject batchInsert(List<Forum> forums);

    /**
     * 删除单个论坛
     * @param forumId
     * @return
     */
    ResponseObject delete(int forumId);

    /**
     * 修改论坛信息
     * @param forum
     * @return
     */
    ResponseObject update(Forum forum);

    /**
     * 根据论坛id查询论坛
     * @param forumId
     * @return
     */
    ResponseObject get(int forumId);




}
