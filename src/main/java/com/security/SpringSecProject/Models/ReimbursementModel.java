package com.security.SpringSecProject.Models;

import com.security.SpringSecProject.Beans.ProductBean;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
public class ReimbursementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String empName;
    private int empNumber;
    private String productType;
    private String productName;
    private String productProvider;
    private double amount;
    private String submissionDate;
    private String isApproved ="pending";
    private String approvalDate;
    private String approvedRemarks;
   // @ManyToOne
    private int employeeId;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getApprovedRemarks() {
        return approvedRemarks;
    }

    public void setApprovedRemarks(String approvedRemarks) {
        this.approvedRemarks = approvedRemarks;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "ReimbursementModel{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empNumber=" + empNumber +
                ", productType='" + productType + '\'' +
                ", productName='" + productName + '\'' +
                ", productProvider='" + productProvider + '\'' +
                ", amount=" + amount +
                ", submissionDate='" + submissionDate + '\'' +
                ", isApproved='" + isApproved + '\'' +
                ", approvalDate='" + approvalDate + '\'' +
                ", approvedRemarks='" + approvedRemarks + '\'' +
                ", employeeId=" + employeeId +
                '}';
    }

    public ReimbursementModel() {
    }

    public ReimbursementModel(ProductBean p, int eId ){
        this.employeeId = eId;
        this.empName = p.getEmpName();
        this.empNumber = p.getEmpNumber();
        this.productType = p.getProductType();
        this.productName = p.getProductName();
        this.productProvider = p.getProductProvider();
        this.amount = p.getAmount();
        this.submissionDate = LocalDate.now().toString();
    }


    public ReimbursementModel( String empName, int empNumber, String productType, String productName, String productProvider, double amount, String submissionDate, String isApproved, String approvalDate, String approvedRemarks, int employeeId) {
        this.empName = empName;
        this.empNumber = empNumber;
        this.productType = productType;
        this.productName = productName;
        this.productProvider = productProvider;
        this.amount = amount;
        this.submissionDate = submissionDate;
        this.isApproved = isApproved;
        this.approvalDate = approvalDate;
        this.approvedRemarks = approvedRemarks;
        this.employeeId = employeeId;
    }
}
