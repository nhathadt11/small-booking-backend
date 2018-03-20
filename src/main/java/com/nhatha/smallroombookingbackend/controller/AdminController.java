package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.AdminNotFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import com.nhatha.smallroombookingbackend.persistance.repository.AdminRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.AdminSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admins")
public class AdminController {
  private final BCryptPasswordEncoder bCryptPasswordEncoder;
  private final AdminRepository adminRepository;

  @Autowired
  public AdminController(AdminRepository adminRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.adminRepository = adminRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @GetMapping()
  public Iterable<Admin> findAll() {
    return adminRepository.findAll();
  }

  @GetMapping("/{id}")
  public Admin findOne(@PathVariable int id) {
    return adminRepository
        .findById(id)
        .orElseThrow(AdminNotFoundException::new);
  }

  @GetMapping("/name/{name}")
  public Iterable<Admin> findAll(@PathVariable String name) {
    return adminRepository
        .findAll(AdminSpecifications.firstNameOrLastNameLike(name));
  }

  @PostMapping()
  @ResponseStatus(HttpStatus.CREATED)
  public Admin create(@RequestBody Admin admin) {
    admin.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));

    return adminRepository.save(admin);
  }

  @PutMapping()
  public Admin update(@RequestBody Admin admin) {
    adminRepository
        .findById(admin.getId())
        .orElseThrow(AdminNotFoundException::new);
    return adminRepository.save(admin);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    adminRepository
        .findById(id)
        .orElseThrow(AdminNotFoundException::new);
    adminRepository.deleteById(id);
  }
}
