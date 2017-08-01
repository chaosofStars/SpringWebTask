package com.netease.course.service.webServiceImpl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService extends WebService {
    @Autowired
    public DeleteService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super(transactionTableDao, contentDao);
    }


    public void deleteProduct(Integer productId) {
        ContentDao contentDao = getContentDao();
        contentDao.deleteContent(productId);
    }


}
