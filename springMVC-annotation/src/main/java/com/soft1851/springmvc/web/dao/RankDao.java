package com.soft1851.springmvc.web.dao;

import com.soft1851.springmvc.web.entity.Rank;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/29 00:17
 * @Description:
 */
public interface RankDao {
    int[] batchInsert(List<Rank> ranks);

    int insert(Rank rank);
}
