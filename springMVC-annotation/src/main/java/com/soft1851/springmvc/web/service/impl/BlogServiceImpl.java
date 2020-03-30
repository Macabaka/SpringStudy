package com.soft1851.springmvc.web.service.impl;

import com.soft1851.springmvc.web.dao.BlogDao;
import com.soft1851.springmvc.web.entity.Blog;
import com.soft1851.springmvc.web.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 01:56
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BlogServiceImpl implements BlogService {

    @Resource private BlogDao blogDao;
    @Override
    public int[] batchinsert(List<Blog> blogList) {
        return blogDao.batchInsert(blogList);
    }

    @Override
    public List<Blog> selectAll() {
        return blogDao.selectAll();
    }
}
