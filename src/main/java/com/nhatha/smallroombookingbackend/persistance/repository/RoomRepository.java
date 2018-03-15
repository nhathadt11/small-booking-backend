package com.nhatha.smallroombookingbackend.persistance.repository;

import com.nhatha.smallroombookingbackend.persistance.model.Room;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer>, JpaSpecificationExecutor<Room> {
  List<Room> findByName(String name);
  List<Room> findAll(Specification<Room> specification);
}
