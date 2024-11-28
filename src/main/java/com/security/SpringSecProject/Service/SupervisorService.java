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

    public ResponseEntity<Object> updateReimbursement(UpdateBean updateBean, String string, int id) {
        Optional<ReimbursementModel> byId = reimbursementRepo.findById(id);
        if(byId.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Optional.of(byId), HttpStatus.OK);
    }
}
