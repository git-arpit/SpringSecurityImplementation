package com.security.SpringSecProject.Beans;

import org.springframework.stereotype.Component;

@Component
public class UpdateBean {
    private String isApproved;
    private String approvedRemarks;

    public UpdateBean(String isApproved, String approvedRemarks) {
        this.isApproved = isApproved;
        this.approvedRemarks = approvedRemarks;
    }

    @Override
    public String toString() {
        return "UpdateBean{" +
                "isApproved='" + isApproved + '\'' +
                ", approvedRemarks='" + approvedRemarks + '\'' +
                '}';
    }

    public UpdateBean() {
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public String getApprovedRemarks() {
        return approvedRemarks;
    }

    public void setApprovedRemarks(String approvedRemarks) {
        this.approvedRemarks = approvedRemarks;
    }
}
