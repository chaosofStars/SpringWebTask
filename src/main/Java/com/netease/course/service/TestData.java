package com.netease.course.service;

import com.netease.course.dao.ContentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.UnsupportedEncodingException;


public class TestData {


    public static void main(String[] args) throws UnsupportedEncodingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");

        ContentDao dao = context.getBean("contentDao", ContentDao.class);
//        TransactionTableDao dao = context.getBean("transactionTableDao", TransactionTableDao.class);
        byte[] bytes = "image".getBytes();
//        dao.insertContent(1,"title",bytes,"summary",bytes);
        System.out.println(dao.getContentLastId());
        ((ConfigurableApplicationContext) context).close();
    }
}
