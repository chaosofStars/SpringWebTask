package com.netease.course.service.impl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.meta.Content;
import com.netease.course.service.WebService;
import com.netease.course.service.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class DeleteService implements WebService{
    private TransactionTableDao transactionTableDao;
    private ContentDao contentDao;

    @Autowired
    public DeleteService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super();
        this.transactionTableDao = transactionTableDao;
        this.contentDao = contentDao;
    }


    public void deleteProduct(Integer productId) {
        contentDao.deleteContent(productId);
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
