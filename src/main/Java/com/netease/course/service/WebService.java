package com.netease.course.service;


import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.meta.Content;
import com.netease.course.meta.product.Product;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public abstract class WebService {
    /**
     * 子类对象的transactionTableDao，contentDao对象均从这里继承
     */
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
