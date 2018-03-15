package com.nhatha.smallroombookingbackend.persistance.specification;

import com.nhatha.smallroombookingbackend.persistance.model.Service;
import com.nhatha.smallroombookingbackend.persistance.model.Service_;
import org.springframework.data.jpa.domain.Specification;

public class ServiceSpecifications {
  public static Specification<Service> hasNameLike(String name) {
    return (root, query, cb) -> cb.like(root.get(Service_.name), "%" + name + "%");
  }

  public static Specification<Service> hasPriceBetween(float from, float to) {
    return (root, query, cb) -> cb.between(root.get(Service_.price), from, to);
  }
}
