package com.security.SpringSecProject.Controller;

import com.security.SpringSecProject.Beans.UserLoginBean;
import org.springframework.core.codec.ByteArrayDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class PublicController {

    @PostMapping("/logins")
    public ResponseEntity<?> login(@RequestBody UserLoginBean loginBean){
        // returns JWT or
        return new ResponseEntity<>(loginBean, HttpStatus.BAD_REQUEST);
    }
    @PreAuthorize("hasAnyRole('NORMAL','ADMIN')")
   @GetMapping("/check")
    public ResponseEntity<?> login(){
        // returns JWT or
        return new ResponseEntity<>("Inside Check",HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<?> adminOnly(){
        // returns JWT or
        return new ResponseEntity<>("Inside Admin",HttpStatus.OK);
    }

    @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/normal")
    public ResponseEntity<?> normal(){
        // returns JWT or
        return new ResponseEntity<>("Inside Normal",HttpStatus.OK);
    }


}
