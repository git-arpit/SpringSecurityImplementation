package com.security.SpringSecProject;

import com.security.SpringSecProject.Models.RoleModel;
import com.security.SpringSecProject.Models.UserModel;
import com.security.SpringSecProject.Repository.RoleRepo;
import com.security.SpringSecProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecProjectApplication implements CommandLineRunner{
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    UserRepo userRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringSecProjectApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        RoleModel roleEmp = new RoleModel(1,"EMPLOYEE");
        RoleModel roleSup = new RoleModel(2,"SUPERVISOR");
        roleRepo.save(roleEmp);
       roleRepo.save(roleSup);

        userRepo.save(new UserModel("employee1","employee1@dummy.com", "emp123",roleEmp));
       userRepo.save(new UserModel("supervisor1","supervisor1@dummy.com", "supp234",roleSup));
       userRepo.save(new UserModel("employee2","employee2@dummy.com", "emp234",roleEmp));
    }
}
