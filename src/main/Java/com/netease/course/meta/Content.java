package com.netease.course.meta;

import java.util.Arrays;

public class Content {
    int productId;
    String title;
    String summary;
    byte[] detail;
    byte[] image;
    float price;

    @Override
    public String toString() {
        return "Content{" +
                "productId=" + productId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", detail=" + Arrays.toString(detail) +
                ", image=" + Arrays.toString(image) +
                ", price=" + price +
                '}';
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public byte[] getDetail() {
        return detail;
    }

    public void setDetail(byte[] detail) {
        this.detail = detail;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
