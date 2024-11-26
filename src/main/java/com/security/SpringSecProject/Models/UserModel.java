package com.security.SpringSecProject.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    @Column(unique = true)
    private String email;
    private String password;
    @ManyToOne
    private RoleModel roleModel;

    public UserModel(String userName, String email, String password, RoleModel roleModel) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roleModel = roleModel;
    }
}
