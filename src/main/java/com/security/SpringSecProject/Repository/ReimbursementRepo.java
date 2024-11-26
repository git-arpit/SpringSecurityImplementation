package com.security.SpringSecProject.Repository;

import com.security.SpringSecProject.Models.ReimbursementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReimbursementRepo extends JpaRepository<ReimbursementModel, Integer> {
}
