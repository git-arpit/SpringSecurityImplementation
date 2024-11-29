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

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    ReimbursementRepo remiRepo;

    @Autowired
    JwtUtilities jwtUtilities;

    public ResponseEntity<?> addProduct(ProductBean product, HttpServletRequest request) {

        String userId = jwtUtilities.getIdFromJwtToken(jwtUtilities.parseJwt(request));

        ReimbursementModel addedProduct = new ReimbursementModel(product, Integer.parseInt(userId));
        remiRepo.save(addedProduct);

        if (addedProduct != null) {
            return new ResponseEntity<>(addedProduct, HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Not Added", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<?> deleteById(String id, HttpServletRequest request) {
        String userId = jwtUtilities.getIdFromJwtToken(jwtUtilities.parseJwt(request));
        Optional<ReimbursementModel> byId = remiRepo.findById(Integer.parseInt(id));
        if (byId.isPresent()) {
            if(byId.get().getEmployeeId()==Integer.parseInt(userId)){
            remiRepo.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>("You Dont have permission", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
    }
}
