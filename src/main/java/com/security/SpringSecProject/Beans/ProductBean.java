package com.security.SpringSecProject.Beans;

import org.springframework.stereotype.Component;

@Component
public class ProductBean {
    private String empName;
    private int empNumber;
    private String productType;
    private String productName;
    private String productProvider;
    private double amount;
    private String comments;

    public ProductBean(String empName, int empNumber, String productType, String productName, String productProvider, double amount, String comments) {
        this.empName = empName;
        this.empNumber = empNumber;
        this.productType = productType;
        this.productName = productName;
        this.productProvider = productProvider;
        this.amount = amount;
        this.comments = comments;
    }

    public ProductBean() {
    }

    @Override
    public String toString() {
        return "ProductBean{" +
                "empName='" + empName + '\'' +
                ", empNumber=" + empNumber +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", productProvider='" + productProvider + '\'' +
                ", amount=" + amount +
                ", comments='" + comments + '\'' +
                '}';
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(int empNumber) {
        this.empNumber = empNumber;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductProvider() {
        return productProvider;
    }

    public void setProductProvider(String productProvider) {
        this.productProvider = productProvider;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
