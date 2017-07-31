package com.netease.course.service.product;

public class EditProduct {
    private int id;
    private String title;
    private String image;
    private float price;
    private String summary;
    private String detail;


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

    @Override
    public String toString() {
        return "EditProduct{" +
                "title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", summary='" + summary + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
