package com.netease.course.service.impl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.meta.Content;
import com.netease.course.service.WebService;
import com.netease.course.service.product.EditProduct;
import com.netease.course.service.product.Product;
import com.netease.course.utils.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EditAndPublicService implements WebService {
    private TransactionTableDao transactionTableDao;
    private ContentDao contentDao;

    @Autowired
    public EditAndPublicService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super();
        this.transactionTableDao = transactionTableDao;
        this.contentDao = contentDao;
    }

    public void updateProduct(EditProduct product) throws UnsupportedEncodingException {
        int productId = product.getId();
        String title = product.getTitle();
        byte[] image = TransformUtil.toByte(product.getImage());
        byte[] detail = TransformUtil.toByte(product.getDetail());
        float price = product.getPrice();
        String summary = product.getSummary();
        contentDao.updateContent(productId, price, title, image, summary, detail);
        System.out.println("updateProduct success");
    }


    public Product saveProduct(EditProduct product) throws UnsupportedEncodingException {
        String title = product.getTitle();
        byte[] image = TransformUtil.toByte(product.getImage());
        byte[] detail = TransformUtil.toByte(product.getDetail());
        float price = product.getPrice();
        String summary = product.getSummary();

        contentDao.insertContent(price,title,image,summary,detail);
        Product product1 = new Product(contentDao.getContentLastId(),title,image,summary,detail);
        product1.setPrice(price);
        return product1;
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
