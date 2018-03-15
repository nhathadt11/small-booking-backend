package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.ServiceNotFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.Service;
import com.nhatha.smallroombookingbackend.persistance.repository.ServiceRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.ServiceSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("services")
public class ServiceController {
  private final ServiceRepository serviceRepository;

  @Autowired
  public ServiceController(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }

  @GetMapping
  public Iterable<Service> findAll() {
    return serviceRepository.findAll();
  }

  @GetMapping("{id}")
  public Service findOne(@PathVariable int id) {
    return serviceRepository
        .findById(id)
        .orElseThrow(ServiceNotFoundException::new);
  }

  @GetMapping("/name/{name}")
  public List<Service> findByName(@PathVariable String name) {
    return serviceRepository.findAll(ServiceSpecifications.hasNameLike(name));
  }

  @GetMapping("/price/from/{from}/to/{to}")
  public List<Service> findByPriceBetween(@PathVariable float from, @PathVariable float to) {
    return serviceRepository.findAll(ServiceSpecifications.hasPriceBetween(from, to));
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Service create(@RequestBody Service service) {
    return serviceRepository.save(service);
  }

  @PutMapping
  @ResponseBody
  public Service update(@RequestBody Service service) {
    serviceRepository
        .findById(service.getId())
        .orElseThrow(ServiceNotFoundException::new);
    return serviceRepository.save(service);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    serviceRepository
        .findById(id)
        .orElseThrow(ServiceNotFoundException::new);
    serviceRepository.deleteById(id);
  }
}
