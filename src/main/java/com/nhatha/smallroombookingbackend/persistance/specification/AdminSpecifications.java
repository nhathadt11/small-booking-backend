package com.nhatha.smallroombookingbackend.persistance.specification;

import com.nhatha.smallroombookingbackend.persistance.model.Admin;
import com.nhatha.smallroombookingbackend.persistance.model.Admin_;
import org.springframework.data.jpa.domain.Specification;

public final class AdminSpecifications {
  public static Specification<Admin> firstNameOrLastNameLike(String name) {
    return (root, query, cb) -> cb.or(
        cb.like(root.get(Admin_.firstName), "%" + name + "%"),
        cb.like(root.get(Admin_.lastName), "%" + name + "%")
    );
  }
}
