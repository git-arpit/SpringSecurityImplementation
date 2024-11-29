package com.security.SpringSecProject.Service;

import com.security.SpringSecProject.Beans.ProductBean;
import com.security.SpringSecProject.JWTUtilities.JwtUtilities;
import com.security.SpringSecProject.Models.ReimbursementModel;
import com.security.SpringSecProject.Repository.ReimbursementRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    ReimbursementRepo remiRepo;

    @Autowired
    JwtUtilities jwtUtilities;

    public ResponseEntity<?> addProduct(ProductBean product, HttpServletRequest request) {

        // String userId = jwtUtilities.getUserIdFromJwtToken(token);
        String userId = jwtUtilities.getIdFromJwtToken(jwtUtilities.parseJwt(request));

        ReimbursementModel addedProduct = new ReimbursementModel(product, Integer.parseInt(userId));
        remiRepo.save(addedProduct);

        if (addedProduct != null) {
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Not Added", HttpStatus.BAD_REQUEST);


    }
}
