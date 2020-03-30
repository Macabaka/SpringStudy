package com.soft1851.springmvc.web.service;

import com.soft1851.springmvc.web.entity.Blog;

import java.util.List;

public interface BlogService {

    int[] batchinsert(List<Blog> blogList);

    List<Blog> selectAll();
}
