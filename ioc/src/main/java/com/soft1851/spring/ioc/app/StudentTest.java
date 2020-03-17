package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Grade;
import com.soft1851.spring.ioc.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author dyf
 */
public class StudentTest {
    private static Logger logger = (Logger) LoggerFactory.getLogger(StudentTest.class);
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student student1 = (Student) ac.getBean("student1");
        Student student2 = (Student) ac.getBean("student2");
        logger.info(student1.toString());
        logger.info(student2.toString());
        Grade grade1 = (Grade) ac.getBean("grade");
        logger.info(grade1.toString());
    }
}
