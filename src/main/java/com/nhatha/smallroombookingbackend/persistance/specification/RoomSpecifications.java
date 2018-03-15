package com.nhatha.smallroombookingbackend.persistance.specification;

import com.nhatha.smallroombookingbackend.persistance.model.Room;
import com.nhatha.smallroombookingbackend.persistance.model.Room_;
import org.springframework.data.jpa.domain.Specification;

public final class RoomSpecifications {
  public static Specification<Room> hasNameLike(String name) {
    return (root, query, cb) -> cb.like(root.get(Room_.name), "%" + name + "%");
  }
}
