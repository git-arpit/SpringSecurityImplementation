package com.security.SpringSecProject.Controller;

import com.security.SpringSecProject.Beans.ProductBean;
import com.security.SpringSecProject.Beans.UserLoginBean;
import com.security.SpringSecProject.JWTUtilities.JwtUtilities;
import com.security.SpringSecProject.Service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

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
    SupervisorService supervisorService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginBean loginBean) {
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginBean.getEmail(), loginBean.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginBean.getEmail());
            System.out.println(userDetails.getUsername());
            return new ResponseEntity<>(jwtUtilities.generateToken(userDetails.getUsername()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(loginBean, HttpStatus.BAD_REQUEST);
        }

    }

    //@PreAuthorize("hasAnyRole('EMPLOYEE','SUPERVISOR')")
    @GetMapping("/check")
    public ResponseEntity<?> login() {
        // returns JWT or
        return new ResponseEntity<>("Inside Check", HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> adminOnly() {
        // returns JWT or
        return new ResponseEntity<>("Inside SUPERVISOR", HttpStatus.OK);
    }

    //@PreAuthorize("hasRole('EMPLOYEE')")
    @GetMapping("/reimbursement/{employeeNumber}")
    public ResponseEntity<?> supervisor(@PathVariable String employeeNumber) {
        // returns JWT or
        return new ResponseEntity<>("Inside EMPLOYEE " + employeeNumber, HttpStatus.OK);
    }

    @PostMapping("/reimbursement/add")
    public ResponseEntity<?> addProductMethod(@RequestBody ProductBean product) {
        return supervisorService.addProduct(product, 3);


    }

    //@PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/reimbursement/1")
    public ResponseEntity<?> normal1() {
        // returns JWT or
        return new ResponseEntity<>("Inside EMPLOYEE1", HttpStatus.OK);
    }


}
