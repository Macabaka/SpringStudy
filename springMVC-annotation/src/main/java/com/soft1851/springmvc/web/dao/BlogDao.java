package com.soft1851.springmvc.web.dao;

import com.soft1851.springmvc.web.entity.Blog;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 01:49
 * @Description:
 */
public interface BlogDao {
    int[] batchInsert(List<Blog> blogs);

    List<Blog> selectAll();
}
