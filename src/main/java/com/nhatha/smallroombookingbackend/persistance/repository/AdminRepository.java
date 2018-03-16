package com.nhatha.smallroombookingbackend.persistance.repository;

import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AdminRepository extends JpaRepository<Admin, Integer>, JpaSpecificationExecutor<Admin> {
}
