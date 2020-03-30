package com.soft1851.springmvc.web.controller;

import com.soft1851.springmvc.web.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author Jack
 * @Date: 2020/3/29 02:37
 * @Description:
 */
@Controller
public class BlogController {
    @Resource
    private BlogService blogService;

    @GetMapping("/blog")
    public String blog(Model model){
        model.addAttribute("blogs",blogService.selectAll());
        return "blog";
    }
}
