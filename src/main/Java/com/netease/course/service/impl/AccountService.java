package com.netease.course.service.impl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.meta.Content;
import com.netease.course.meta.TransactionTable;
import com.netease.course.meta.User;
import com.netease.course.service.WebService;
import com.netease.course.service.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements WebService {
    private TransactionTableDao transactionTableDao;
    private ContentDao contentDao;

    @Autowired
    public AccountService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super();
        this.transactionTableDao = transactionTableDao;
        this.contentDao = contentDao;
    }

    public List<Product> getProductsByUser(User user) throws UnsupportedEncodingException {
        List<Product> products = new ArrayList<Product>();
        List<TransactionTable> tables = transactionTableDao.listTables();
        for (TransactionTable table : tables) {
            int productId = table.getProductId();
            Content content = contentDao.getContentById(productId);
            String title = content.getTitle();
            byte[] image = content.getImage();
            float price = content.getPrice();

            float buyPrice = table.getBuyPrice();
            int buyNum = table.getNum();
            long buyTime = table.getTime();
            float total = buyNum * buyPrice;

            Product product = new Product(productId, title, image, price);
            product.setBuyPrice(buyPrice);
            product.setBuyNum(buyNum);
            product.setBuyTime(buyTime);
            product.setTotal(total);
            products.add(product);
        }
        return products;
    }

}
