package com.security.SpringSecProject.Service;

import com.security.SpringSecProject.Models.ReimbursementModel;
import com.security.SpringSecProject.Repository.ReimbursementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommonService {

    @Autowired
    ReimbursementRepo repo;

    public ResponseEntity<Object> getAllEmp(int employeeId){
        Optional<List<ReimbursementModel>> byEmpNumber = repo.findByEmpNumber(employeeId);
        if(byEmpNumber.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(Optional.of(byEmpNumber), HttpStatus.OK);
    }
}
