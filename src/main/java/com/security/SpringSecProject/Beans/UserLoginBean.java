package com.security.SpringSecProject.Beans;

import lombok.Data;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserLoginBean {
    private String email;
    private String password;
}
