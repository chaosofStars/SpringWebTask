package com.netease.course.service.webServiceImpl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.service.WebService;
import com.netease.course.meta.product.EditProduct;
import com.netease.course.meta.product.Product;
import com.netease.course.utils.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EditAndPublicService extends WebService {
    @Autowired
    public EditAndPublicService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super(transactionTableDao, contentDao);
    }

    public void updateProduct(EditProduct product) throws UnsupportedEncodingException {
        ContentDao contentDao = getContentDao();
        int productId = product.getId();
        String title = product.getTitle();
        byte[] image = TransformUtil.toByte(product.getImage());
        byte[] detail = TransformUtil.toByte(product.getDetail());
        float price = product.getPrice();
        String summary = product.getSummary();
        contentDao.updateContent(productId, price, title, image, summary, detail);
        System.out.println("updateProduct success");
    }

    /*
     * 保存到表中
     */
    public Product saveProduct(EditProduct product) throws UnsupportedEncodingException {
        ContentDao contentDao = getContentDao();
        //需要填充的属性
        String title = product.getTitle();
        byte[] image = TransformUtil.toByte(product.getImage());
        byte[] detail = TransformUtil.toByte(product.getDetail());
        float price = product.getPrice();
        String summary = product.getSummary();
        //插入表中
        contentDao.insertContent(price,title,image,summary,detail);
        //返回对象
        Product product1 = new Product(contentDao.getContentLastId(),title,image,summary,detail);
        product1.setPrice(price);
        return product1;
    }


}
