package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Grade;
import com.soft1851.spring.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jack
 * @Date: 2020/3/19 17:02
 * @Description:
 */
@Configuration
public class GradeConfig {
    @Bean
    public Grade grade(){
        Grade grade = new Grade();
        grade.setName("软件1851");
        List phoneList = new ArrayList(){{
            this.add("phone");
        }};
        List hobbyList = new ArrayList(){{
            this.add("吃饭");
            this.add("学习");
        }};
        Map studentMap = new HashMap();
        for(int i =0;i<3;i++){
            Student student = new Student();
            student.setName("小同学"+i);
            student.setId(12+i);
            student.setPhone(phoneList);
            student.setHobbies(hobbyList);
            studentMap.put("student"+i,student);
        }
        grade.setStudents(studentMap);
        return grade;
    }
}
