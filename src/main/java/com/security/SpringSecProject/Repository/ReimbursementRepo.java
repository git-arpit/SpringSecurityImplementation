package com.security.SpringSecProject.Repository;

import com.security.SpringSecProject.Models.ReimbursementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReimbursementRepo extends JpaRepository<ReimbursementModel, Integer> {

    Optional<List<ReimbursementModel>> findByEmpNumber(String empNo);


}
