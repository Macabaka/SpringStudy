package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.ForumDao;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/21 11:05
 * @Description:
 */
@Service
public class ForumServiceImpl implements ForumService {
    private ForumDao forumDao;

    public ForumServiceImpl(ForumDao forumDao) {
        this.forumDao = forumDao;
    }

    @Override
    public ResponseObject selectAll() {
        List<Forum> forumList = forumDao.selectAll();
        if(forumList.size()!=0){
            return new ResponseObject(1,"成功",forumList);
        }
        return new ResponseObject(1,"错误",null);
    }

    @Override
    public ResponseObject insert(Forum forum) {
        int row = forumDao.insert(forum);
        if(row==1){
            return new ResponseObject(1,"成功",null);
        }
        return new ResponseObject(1,"错误",null);
    }

    @Override
    public ResponseObject batchInsert(List<Forum> forums) {
        int[] row = forumDao.batchInsert(forums);
        if(row.length!=0){
            return new ResponseObject(1,"成功",null);
        }
        return new ResponseObject(1,"错误",null);
    }

    @Override
    public ResponseObject delete(int forumId) {
        int row = forumDao.delete(forumId);
        if(row==1){
            return new ResponseObject(1,"成功",null);
        }
        return new ResponseObject(1,"错误",null);
    }

    @Override
    public ResponseObject update(Forum forum) {
        int row = forumDao.update(forum);
        if(row==1){
            return new ResponseObject(1,"成功",null);
        }
        return new ResponseObject(1,"错误",null);
    }

    @Override
    public ResponseObject get(int forumId) {

        Forum forum = forumDao.get(forumId);
        if(forum!=null){
            return new ResponseObject(1,"成功",forum);
        }
        return new ResponseObject(1,"错误",null);
    }

}
