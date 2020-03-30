package com.soft1851.springmvc.web.service;

import com.soft1851.springmvc.web.entity.Rank;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 00:24
 * @Description:
 */
public interface RankService {
    int[] batchInsert(List<Rank> ranks);
}
