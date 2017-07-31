package com.netease.course.service.product;


import com.netease.course.utils.TransformUtil;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;

public  class Product {
    private int id;
    private String title;
    private String image;
    private float price;

    private String summary;
    private String detail;


    private float buyPrice;
    private int buyNum;
    private long buyTime;
    private int saleNum;
    private float total;
    private int isBuy = 0;
    private int isSell = 0;



    public Product(int id, String title, byte[] image, float price ) throws UnsupportedEncodingException {
        this.id = id;
        this.title = title;
        this.image = TransformUtil.toString(image);
        this.price = price;
    }

    public Product(int id, String title, byte[] image, String summary, byte[] detail) throws UnsupportedEncodingException {
        this.id = id;
        this.title = title;
        this.image = TransformUtil.toString(image);
        this.summary = summary;
        this.detail = TransformUtil.toString(detail);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public long getBuyTime() {
        return buyTime;
    }

    public void setBuyTime(long buyTime) {
        this.buyTime = buyTime;
    }

    public int getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(int saleNum) {
        this.saleNum = saleNum;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getIsBuy() {
        return isBuy;
    }

    public void setIsBuy(int isBuy) {
        this.isBuy = isBuy;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                ", buyPrice=" + buyPrice +
                ", buyNum=" + buyNum +
                ", buyTime=" + buyTime +
                ", saleNum=" + saleNum +
                ", total=" + total +
                ", isBuy=" + isBuy +
                ", isSell=" + isSell +
                '}';
    }
}
