package com.security.SpringSecProject.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Data
@NoArgsConstructor
public class ReimbursementModel {
    @Id
    private int id;
    private String empName;
    private int empNumber;
    private String productType;
    private String productName;
    private String productProvider;
    private double amount;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String submissionDate;
    @ColumnDefault("'pending'")
    private String isApproved;
    @Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String approvalDate;
    private String approvedRemarks;
    @ManyToOne
    private UserModel employeeId;

}
