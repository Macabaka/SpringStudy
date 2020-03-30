package com.soft1851.springmvc.web.service.impl;

import com.soft1851.springmvc.web.dao.RankDao;
import com.soft1851.springmvc.web.entity.Rank;
import com.soft1851.springmvc.web.service.RankService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 00:25
 * @Description:
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RankServiceImpl  implements RankService {
    @Resource
    private RankDao rankDao;

    @Override
    public int[] batchInsert(List<Rank> ranks) {
        return rankDao.batchInsert(ranks);
    }
}
