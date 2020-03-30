package com.soft1851.springmvc.web.controller;

import com.soft1851.springmvc.web.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/24 10:47
 * @Description:
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message", "Hello springMVC annotation");
        String[] books = {"java","python","微信小程序"};
        model.addAttribute("books", getBooks());
        return "home";
    }


    private List<Book> getBooks(){
        List<Book> bookList = new ArrayList<>(){
            {
                this.add(Book.builder().name("活着").build());
                this.add(Book.builder().name("解忧杂货店").build());
                this.add(Book.builder().name("追风筝的人").build());
                this.add(Book.builder().name("白夜行").build());
                this.add(Book.builder().name("红楼梦").build());
                this.add(Book.builder().name("82年生的金智英").build());
                this.add(Book.builder().name("百年孤独").build());
                this.add(Book.builder().name("嫌疑人X的献身").build());
                this.add(Book.builder().name("霍乱时期的爱情").build());
                this.add(Book.builder().name("呼吸").build());
                this.add(Book.builder().name("围城").build());
                this.add(Book.builder().name("平凡的世界（全三部）").build());
                this.add(Book.builder().name("小王子").build());
            }
        };
        return bookList;
    }
}
