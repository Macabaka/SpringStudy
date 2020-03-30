package com.soft1851.springmvc.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.springmvc.web.service.TopicService;
import com.soft1851.springmvc.web.util.ResponseObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Jack
 * @Date: 2020/3/28 18:21
 * @Description:
 */
@Controller
@RequestMapping(value="/")
public class TopicController {
    @Resource
    private TopicService topicService;

    @GetMapping(value="topics",produces="application/json;charset=utf-8")
    @ResponseBody
    public String getTopics(){
        ResponseObject responseObject = new ResponseObject(1, "success", topicService.queryAll());
        return JSONObject.toJSONString(responseObject);
    }

    @GetMapping("/topic")
    public String topic(Model model){
        model.addAttribute("topics", topicService.queryAll());
        return "topic";
    }
}
