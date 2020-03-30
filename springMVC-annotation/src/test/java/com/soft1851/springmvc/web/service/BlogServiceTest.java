package com.soft1851.springmvc.web.service;

import com.soft1851.springmvc.web.config.SpringDataSourceConfig;
import com.soft1851.springmvc.web.util.CsdnSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class BlogServiceTest {
    @Autowired
    private BlogService blogService;
    @Test
    public void batchinsert() {
        blogService.batchinsert(CsdnSpider.getBlog());
    }

    @Test
    public void selectAll() {
        System.out.println(blogService.selectAll().size());
    }
}