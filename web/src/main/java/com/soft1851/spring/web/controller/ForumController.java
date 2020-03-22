package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.entity.Forum;
import com.soft1851.spring.web.entity.dto.BatchInsertForum;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/21 10:09
 * @Description:
 */
@RestController
@RequestMapping(value ="forum")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @RequestMapping(value="/all",produces = "application/json;charset=utf-8")
    public String selectAll(){
        ResponseObject responseObject = forumService.selectAll();
        return JSON.toJSONString(responseObject);
    }

    @DeleteMapping(value = "/delete",produces = "application/json;charset=utf-8")
    public String delete(@RequestParam int forumId){
        ResponseObject responseObject = forumService.delete(forumId);
        return JSON.toJSONString(responseObject);
    }



    @PostMapping(value="/select",produces = "application/json;charset=utf-8")
    public String select(@RequestParam int forumId){
        ResponseObject responseObject = forumService.get(forumId);
        return JSON.toJSONString(responseObject);
    }

    @PostMapping(value = "/batch/insert",produces = "application/json;charset=utf-8")
    public String batchInsert(BatchInsertForum batchInsertForum){
        System.out.println(batchInsertForum);
        ResponseObject responseObject = forumService.batchInsert(batchInsertForum.getForumList());
        return JSON.toJSONString(responseObject);
    }

    @PostMapping(value="/insert", produces = "application/json;")
    public String insert( Forum forum){
        ResponseObject responseObject = forumService.insert(forum);
        return JSON.toJSONString(responseObject);
    }

    @PostMapping(value="/update",produces = "application/json;charset=utf-8")
    public String update( Forum forum){
        ResponseObject responseObject = forumService.update(forum);
        return JSON.toJSONString(responseObject);
    }
}
