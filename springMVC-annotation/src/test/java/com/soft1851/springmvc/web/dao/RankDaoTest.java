package com.soft1851.springmvc.web.dao;

import com.soft1851.springmvc.web.config.SpringDataSourceConfig;
import com.soft1851.springmvc.web.entity.Rank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class RankDaoTest {
    @Autowired
    private  RankDao rankDao;

    @Test
    public void batchInsert() {
        List<Rank> rankList = new ArrayList<>(){{
            this.add(Rank.builder().title("21313").author("1231231").duration("123123").pic("123123").build());
            this.add(Rank.builder().title("21313").author("1231231").duration("123123").pic("123123").build());
            this.add(Rank.builder().title("21313").author("1231231").duration("123123").pic("123123").build());
        }};
        int row = rankDao.batchInsert(rankList).length;
    }
}