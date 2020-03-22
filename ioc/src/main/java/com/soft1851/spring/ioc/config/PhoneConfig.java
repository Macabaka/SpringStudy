package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Phone;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Jack
 * @Date: 2020/3/19 17:15
 * @Description:
 */
@Configuration
public class PhoneConfig {
    @Bean
    public Phone phone(){
        Phone phone = new Phone();
        phone.setBrand("苹果");
        phone.setPrice(8000.0);
        return phone;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PhoneConfig.class);
        ac.scan("com.soft1851.spring.ioc.com.soft1851.spring.orm.config");
        Phone phone = (Phone)ac.getBean("phone");
        System.out.println(phone);

    }

}
