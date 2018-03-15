package com.nhatha.smallroombookingbackend.persistance.repository;

import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin> {
  List<Admin> findByFirstName(String name);
  List<Admin> findByLastName(String name);
  List<Admin> findByPhone(String phone);
  List<Admin> findByEmail(String email);
}
