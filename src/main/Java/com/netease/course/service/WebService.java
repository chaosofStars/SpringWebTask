package com.netease.course.service;


import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.meta.Content;
import com.netease.course.service.product.Product;

import java.io.UnsupportedEncodingException;


public abstract class WebService {
    private TransactionTableDao transactionTableDao;
    private ContentDao contentDao;

    public WebService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        this.transactionTableDao = transactionTableDao;
        this.contentDao = contentDao;
    }

    public TransactionTableDao getTransactionTableDao() {
        return transactionTableDao;
    }

    public ContentDao getContentDao() {
        return contentDao;
    }

    public Product getProductById(int productId) throws UnsupportedEncodingException {
        Content content = contentDao.getContentById(productId);
        Product product = null;
        if (content != null) {
            String title = content.getTitle();
            byte[] image = content.getImage();
            float price = content.getPrice();
            String summary = content.getSummary();
            byte[] detail = content.getDetail();

            product = new Product(productId, title,
                    image, summary, detail);
            product.setPrice(price);
        }
        return product;
    }

}
