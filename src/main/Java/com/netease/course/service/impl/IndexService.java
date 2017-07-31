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
public class IndexService implements WebService {
    private TransactionTableDao transactionTableDao;
    private ContentDao contentDao;

    @Autowired
    public IndexService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super();
        this.transactionTableDao = transactionTableDao;
        this.contentDao = contentDao;
    }

    public List<Product> listProductByUser(User user) throws UnsupportedEncodingException {
        List<Product> products = listProduct();
        if (!products.isEmpty()) {
            for (Product product : products) {
                int productId = product.getId();
                if ((!transactionTableDao.getTrxByProductId(productId).isEmpty())) {
                    System.out.println(transactionTableDao.getTrxByProductId(productId));
                    product.setIsBuy(1);
                    product.setIsSell(1);
                }
            }
        }
        return products;
    }

    public List<Product> listProduct() throws UnsupportedEncodingException {
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
