package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/19 16:48
 * @Description:
 */
@Configuration
public class StudentConfig {
    @Bean
    public Student student(){
        Student student = new Student();
        student.setId(1);
        student.setName("小王");
        List hobbyList = new ArrayList(){{
            this.add("吃饭");
            this.add("睡觉");
            this.add("打豆豆");
        }};
        student.setHobbies(hobbyList);
        List phoneList = new ArrayList(){{
            this.add("诺基亚");
            this.add("三星");
        }};
        student.setPhone(phoneList);
        return student;
    }
}
