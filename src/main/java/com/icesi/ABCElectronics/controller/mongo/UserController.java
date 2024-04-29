package com.icesi.ABCElectronics.controller.mongo;

import com.icesi.ABCElectronics.Repository.mongo.UserRepository;
import com.icesi.ABCElectronics.entity.mongo.User;
import com.icesi.ABCElectronics.service.mongo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "/{userID}")
    public ResponseEntity getUserByID(@PathVariable(value = "userID") Long userID) {
        try {
            return ResponseEntity.ok(userService.getUserByID(userID));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User userToCreate) {
        return ResponseEntity.ok(userService.createUser(userToCreate));
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody User userToUpdate) {
        try {
            return ResponseEntity.ok(userService.updateUser(userToUpdate));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping(value = "/{userID}")
    public ResponseEntity deleteUser(@PathVariable(value = "userID") Long userID) {
        try {
            userService.deleteUser(userID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
