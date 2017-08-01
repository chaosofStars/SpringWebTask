package com.netease.course.service.impl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.meta.Content;
import com.netease.course.meta.User;
import com.netease.course.service.WebService;
import com.netease.course.service.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class IndexService extends WebService {
    @Autowired
    public IndexService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super(transactionTableDao, contentDao);
    }

    public List<Product> listProductByUser(User user) throws UnsupportedEncodingException {
        TransactionTableDao transactionTableDao = getTransactionTableDao();
        List<Product> products = listProduct();
        if (!products.isEmpty()) {
            for (Product product : products) {
                int productId = product.getId();
                if ((!transactionTableDao.getTrxByProductId(productId).isEmpty())) {
                    product.setIsBuy(1);
                    product.setIsSell(1);
                }
            }
        }
        return products;
    }

    public List<Product> listProduct() throws UnsupportedEncodingException {
        ContentDao contentDao = getContentDao();
        List<Product> products = new ArrayList<Product>();
        List<Content> contents = contentDao.listContents();
        for (Content content : contents) {
            int productId = content.getProductId();
            String title = content.getTitle();
            byte[] image = content.getImage();
            float price = content.getPrice();

            Product product = new Product(productId, title
                    , image, price);
            products.add(product);
        }
        return products;
    }

}
