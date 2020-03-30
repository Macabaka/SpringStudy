package com.soft1851.springmvc.web.service.impl;

import com.soft1851.springmvc.web.dao.TopicDao;
import com.soft1851.springmvc.web.entity.Topic;
import com.soft1851.springmvc.web.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/28 17:07
 * @Description:
 */
@Service
//开启数据库事务，并且设置回滚的操作
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl  implements TopicService {

    @Resource
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
//        try{
//            int a = 1 / 0;
//        }catch(Exception e){
//            e.printStackTrace();
////            spring嗅探到异常并自动回滚
//            throw new RuntimeException();
//        }
    }
}
