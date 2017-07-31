package com.netease.course.service.impl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;


@Service
public class BuyService extends WebService {
    @Autowired
    public BuyService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super(transactionTableDao, contentDao);
    }

    public void saveTransaction(Integer productId, Integer num, int userId) {
        TransactionTableDao transactionTableDao = getTransactionTableDao();
        ContentDao contentDao = getContentDao();
        Date date = new Date(System.currentTimeMillis());
        float price = contentDao.getContentById(productId).getPrice();
        transactionTableDao.insertTrx(productId,userId,price,date.getTime(),num);
    }
}
