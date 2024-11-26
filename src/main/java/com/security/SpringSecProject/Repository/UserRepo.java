package com.security.SpringSecProject.Repository;

import com.security.SpringSecProject.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer> {
}
