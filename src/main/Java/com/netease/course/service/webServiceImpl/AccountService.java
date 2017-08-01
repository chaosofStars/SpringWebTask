package com.netease.course.service.webServiceImpl;

import com.netease.course.dao.ContentDao;
import com.netease.course.dao.TransactionTableDao;
import com.netease.course.meta.Content;
import com.netease.course.meta.TransactionTable;
import com.netease.course.meta.User;
import com.netease.course.service.WebService;
import com.netease.course.meta.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService extends WebService {
    @Autowired
    public AccountService(TransactionTableDao transactionTableDao, ContentDao contentDao) {
        super(transactionTableDao, contentDao);
    }


    /**
     *
     * @param user 考虑到只有两个买家，就直接抽取的全部记录，后期增加用户只需重新此方法
     * @return 得到用户交易信息
     * @throws UnsupportedEncodingException
     */
    public List<Product> getProductsByUser(User user) throws UnsupportedEncodingException {
        TransactionTableDao transactionTableDao = getTransactionTableDao();
        ContentDao contentDao = getContentDao();

        List<Product> products = new ArrayList<Product>();
        List<TransactionTable> tables = transactionTableDao.listTables();

        //遍历交易表，得到交易信息，填充到Product对象中
        for (TransactionTable table : tables) {
            //需要填充的信息
            int productId = table.getProductId();
            Content content = contentDao.getContentById(productId);
            String title = content.getTitle();
            byte[] image = content.getImage();
            float price = content.getPrice();
            float buyPrice = table.getBuyPrice();
            int buyNum = table.getNum();
            long buyTime = table.getTime();
            float total = buyNum * buyPrice;
            //添加到Product对象中
            Product product = new Product(productId, title, image, price);
            product.setBuyPrice(buyPrice);
            product.setBuyNum(buyNum);
            product.setBuyTime(buyTime);
            product.setTotal(total);
            //添加product到products中
            products.add(product);
        }
        return products;
    }

}
