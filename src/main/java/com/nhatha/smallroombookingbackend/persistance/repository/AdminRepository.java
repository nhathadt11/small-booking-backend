package com.nhatha.smallroombookingbackend.persistance.repository;

import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
  List<Admin> findByFirstName(String name);
  List<Admin> findByLastName(String name);
  List<Admin> findByPhone(String phone);
  List<Admin> findByEmail(String email);
}
