package com.example.ProductFetcher.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodId;

    private String prodName;
    private String prodBrand;
    private String prodCategory;
    private int prodPrice;

    public Product() {
    }

    public Product(int prodId, String prodName, String prodBrand, String prodCategory, int prodPrice) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.prodBrand = prodBrand;
        this.prodCategory = prodCategory;
        this.prodPrice = prodPrice;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdBrand() {
        return prodBrand;
    }

    public void setProdBrand(String prodBrand) {
        this.prodBrand = prodBrand;
    }

    public String getProdCategory() {
        return prodCategory;
    }

    public void setProdCategory(String prodCategory) {
        this.prodCategory = prodCategory;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prodId=" + prodId +
                ", prodName='" + prodName + '\'' +
                ", prodBrand='" + prodBrand + '\'' +
                ", prodCategory='" + prodCategory + '\'' +
                ", prodPrice=" + prodPrice +
                '}';
    }
}
