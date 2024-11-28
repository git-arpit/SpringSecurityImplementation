package com.security.SpringSecProject.Controller;

import com.security.SpringSecProject.Beans.ProductBean;
import com.security.SpringSecProject.Beans.UpdateBean;
import com.security.SpringSecProject.Beans.UserLoginBean;
import com.security.SpringSecProject.JWTUtilities.JwtUtilities;
import com.security.SpringSecProject.Models.UserModel;
import com.security.SpringSecProject.Service.CommonService;
import com.security.SpringSecProject.Service.EmployeeService;
import com.security.SpringSecProject.Service.SupervisorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping
public class MyController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtilities jwtUtilities;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    CommonService commonService;

    @Autowired
    SupervisorService supervisorService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginBean loginBean) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginBean.getEmail(), loginBean.getPassword()));
            UserModel userModel = (com.security.SpringSecProject.Models.UserModel) userDetailsService.loadUserByUsername(loginBean.getEmail());
            return new ResponseEntity<>(jwtUtilities.generateToken(userModel), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(loginBean, HttpStatus.BAD_REQUEST);
        }

    }

    //@PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/reimbursement/{employeeNumber}")
    public ResponseEntity<?> supervisor(@PathVariable String employeeNumber) {
        return commonService.getAllEmp(employeeNumber);
    }

    @PostMapping("/reimbursement/add")
    public ResponseEntity<?> addProductMethod(@RequestBody ProductBean product, HttpServletRequest request) {
        return employeeService.addProduct(product, request);
    }

    @PatchMapping("/reimbursement/update/{id}")
    public ResponseEntity<?> updateMethod(@PathVariable int id , UpdateBean updateBean){
        supervisorService.updateReimbursement(updateBean, LocalDate.now().toString(), id);

    }

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/reimbursement/1")
    public ResponseEntity<?> normal1() {
        // returns JWT or
        return new ResponseEntity<>("Inside EMPLOYEE1", HttpStatus.OK);
    }


}
