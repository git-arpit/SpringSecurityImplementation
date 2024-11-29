package com.security.SpringSecProject.Service;

import com.security.SpringSecProject.Beans.UpdateBean;
import com.security.SpringSecProject.Models.ReimbursementModel;
import com.security.SpringSecProject.Repository.ReimbursementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupervisorService {

    @Autowired
    ReimbursementRepo reimbursementRepo;

    public ResponseEntity<?> updateReimbursement(UpdateBean updateBean, String date, int id) {
        System.out.println("============="+ updateBean);
        Optional<ReimbursementModel> toBeUpdated = reimbursementRepo.findById(id);
        if(toBeUpdated.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        toBeUpdated.get().setIsApproved(updateBean.getIsApproved());
        toBeUpdated.get().setApprovedRemarks(updateBean.getApprovedRemarks());
        toBeUpdated.get().setApprovalDate(date);
        ReimbursementModel updatedRecord = reimbursementRepo.save(toBeUpdated.get());

        return new ResponseEntity<>(updatedRecord, HttpStatus.OK);
    }
}
