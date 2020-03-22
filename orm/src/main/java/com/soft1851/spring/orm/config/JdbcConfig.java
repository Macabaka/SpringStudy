package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.orm.dao.ForumDao;

import com.soft1851.spring.orm.entity.Forum;
import com.soft1851.spring.orm.dao.Impl.ForumDaoImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Jack
 * @Date: 2020/3/19 08:17
 * @Description:
 */
@Configuration
public class JdbcConfig {
    @Bean
    public static  DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/bbs?useUnicode=true&characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setInitialSize(8);
        return dataSource;
    }

    @Bean
    public static JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

    @Bean
    public ForumDao forumDao (JdbcTemplate jdbcTemplate){
        return new ForumDaoImpl(jdbcTemplate);
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(JdbcConfig.class);
        ac.scan("com.soft1851.spring.ioc.com.soft1851.spring.orm.config");
        JdbcTemplate jdbcTemplate= (JdbcTemplate)ac.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);
        ForumDao forumDao = (ForumDao) ac.getBean("forumDao");
        List<Forum> forumList = forumDao.selectAll();
        System.out.println(forumList);
    }

}
