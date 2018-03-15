package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import com.nhatha.smallroombookingbackend.persistance.repository.AdminRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.AdminSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admins")
public class AdminController {
  private final AdminRepository adminRepository;

  @Autowired
  public AdminController(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @GetMapping()
  public Iterable<Admin> findAll() {
    return adminRepository.findAll();
  }

  @GetMapping("/name/{name}")
  public Iterable<Admin> findAll(@PathVariable String name) {
    return adminRepository
        .findAll(AdminSpecifications.firstNameOrLastNameLike(name));
  }
}
