package com.nhatha.smallroombookingbackend.config.security;

import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import com.nhatha.smallroombookingbackend.persistance.repository.AdminRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class LocalUserDetailsService implements UserDetailsService {
  private AdminRepository adminRepository;

  public LocalUserDetailsService(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Admin admin = adminRepository
        .findByEmail(username)
        .orElseThrow(() -> new UsernameNotFoundException(username));

    return new User(admin.getEmail(), admin.getPassword(), emptyList());
  }
}
