package com.nhatha.smallroombookingbackend.utils;

import com.nhatha.smallroombookingbackend.error.AdminNotFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import com.nhatha.smallroombookingbackend.persistance.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public final class WebContextHelper {
  private AdminRepository adminRepository;

  @Autowired
  public WebContextHelper(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  public Admin currentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String username = (String) auth.getPrincipal();

    return
        adminRepository
            .findByEmail(username)
            .orElseThrow(AdminNotFoundException::new);
  }
}
