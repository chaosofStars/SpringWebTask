package com.netease.course.service.impl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class BuyService implements WebService{
    private TransactionTableDao transactionTableDao;
    private ContentDao contentDao;

    @Autowired
    public BuyService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super();
        this.transactionTableDao = transactionTableDao;
        this.contentDao = contentDao;
    }

    public void saveTransaction(Integer productId, Integer num, int userId) {
        Date date = new Date(System.currentTimeMillis());
        float price = contentDao.getContentById(productId).getPrice();
        transactionTableDao.insertTrx(productId,userId,price,date.getTime(),num);
    }
}
