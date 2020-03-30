package com.soft1851.springmvc.web.service;

import com.soft1851.springmvc.web.config.SpringDataSourceConfig;
import com.soft1851.springmvc.web.dao.RankDao;
import com.soft1851.springmvc.web.util.BiLiBiLiSpider;
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
public class RankServiceTest {

    @Autowired
    private RankDao rankDao;

    @Test
    public void batchInsert() {
        int row = rankDao.batchInsert(BiLiBiLiSpider.getRanks()).length;
        System.out.println("行数是"+rankDao.batchInsert(BiLiBiLiSpider.getRanks()).length);
//        assertEquals(rankDao.batchInsert(BiLiBiLiSpider.getRanks()).length,BiLiBiLiSpider.getRanks().size());
    }
}