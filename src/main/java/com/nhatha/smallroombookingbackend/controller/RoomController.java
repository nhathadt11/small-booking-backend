package com.nhatha.smallroombookingbackend.controller;

import com.nhatha.smallroombookingbackend.error.RoomNotFoundException;
import com.nhatha.smallroombookingbackend.persistance.model.Room;
import com.nhatha.smallroombookingbackend.persistance.repository.RoomRepository;
import com.nhatha.smallroombookingbackend.persistance.specification.RoomSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rooms")
public class RoomController {

  private final RoomRepository roomRepository;

  @Autowired
  public RoomController(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  @GetMapping
  public Iterable<Room> findAll() {
    return roomRepository.findAll();
  }


  @GetMapping("/name/{name}")
  public List<Room> findByNameLike(@PathVariable String name) {
    return roomRepository.findAll(RoomSpecifications.hasNameLike(name));
  }

  @GetMapping("/{id}")
  public Room findOne(@PathVariable int id) {
    return roomRepository
        .findById(id)
        .orElseThrow(RoomNotFoundException::new);
  }

  @GetMapping("/available")
  public List<Room> findAllAvailable() {
    return roomRepository.findRoomByAvailable(true);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Room create(@RequestBody Room room) {
    return roomRepository.save(room);
  }

  @DeleteMapping("{id}")
  public void delete(@PathVariable int id) {
    roomRepository
        .findById(id)
        .orElseThrow(RoomNotFoundException::new);
    roomRepository.deleteById(id);
  }

  @PutMapping
  @ResponseBody
  public Room update(@RequestBody Room room) {
    roomRepository
        .findById(room.getId())
        .orElseThrow(RoomNotFoundException::new);
    return roomRepository.save(room);
  }
}
