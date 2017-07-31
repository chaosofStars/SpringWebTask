package com.netease.course.meta;


import java.sql.Date;

public class TransactionTable {
    int productId;
    int userId;
    float buyPrice;
    long time;
    int num;

    @Override
    public String toString() {
        return "TransactionTable{" +
                "productId=" + productId +
                ", userId=" + userId +
                ", buyPrice=" + buyPrice +
                ", time=" + time +
                ", num=" + num +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
