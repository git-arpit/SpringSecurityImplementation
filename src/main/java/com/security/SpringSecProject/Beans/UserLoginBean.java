package com.security.SpringSecProject.Beans;

import org.springframework.stereotype.Component;

@Component
public class UserLoginBean {
    private String email;
    private String password;

    public UserLoginBean() {
    }

    public UserLoginBean(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginBean{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
