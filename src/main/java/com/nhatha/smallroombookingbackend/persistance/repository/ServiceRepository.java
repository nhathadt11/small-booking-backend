package com.nhatha.smallroombookingbackend.persistance.repository;

import com.nhatha.smallroombookingbackend.persistance.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServiceRepository extends JpaRepository<Service, Integer>, JpaSpecificationExecutor<Service> {
}
