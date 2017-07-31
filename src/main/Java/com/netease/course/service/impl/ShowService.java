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
import java.util.List;

@Service
public class ShowService implements WebService {
    private TransactionTableDao transactionTableDao;
    private ContentDao contentDao;

    @Autowired
    public ShowService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super();
        this.transactionTableDao = transactionTableDao;
        this.contentDao = contentDao;
    }

    public Product getProductByUser(Product product, User user) throws UnsupportedEncodingException {
        //0为买家，1为卖家
        List<TransactionTable> trxTables = transactionTableDao.getTrxByProductId(product.getId());
        if (!trxTables.isEmpty()) {
            int num = 0;
            for (TransactionTable trxTable : trxTables) {
                if (user.getUserType() == 0) {
                    product.setIsBuy(1);
                    product.setBuyPrice(trxTable.getBuyPrice());
                    num = num + trxTable.getNum();
                } else {
                    product.setIsSell(1);
                    product.setSaleNum(trxTable.getNum());
                }
            }
            product.setBuyNum(num);
        }
        return product;
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
