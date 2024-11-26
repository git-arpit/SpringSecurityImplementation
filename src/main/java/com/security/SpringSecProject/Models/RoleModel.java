package com.security.SpringSecProject.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@RequiredArgsConstructor
public class RoleModel {
    @Id
    private int id;
    @Column(unique = true)
    private String roleName;

}
