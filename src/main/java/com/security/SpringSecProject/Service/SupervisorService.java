package com.security.SpringSecProject.Service;

import com.security.SpringSecProject.Beans.ProductBean;
import com.security.SpringSecProject.Models.ReimbursementModel;
import com.security.SpringSecProject.Repository.ReimbursementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SupervisorService {
    @Autowired
    ReimbursementRepo reimRepo;

    public ResponseEntity<?> addProduct(ProductBean product, int empId) {

        ReimbursementModel addedProduct = new ReimbursementModel(product, empId);
        reimRepo.save(addedProduct);

        if(addedProduct!=null){
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        }
        return new  ResponseEntity<>( "Not Added", HttpStatus.BAD_REQUEST);



    }
}
