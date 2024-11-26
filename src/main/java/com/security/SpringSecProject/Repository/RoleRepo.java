package com.security.SpringSecProject.Repository;

import com.security.SpringSecProject.Models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel, Integer> {
}
