package com.college.festival.controller;

import com.college.festival.models.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.college.festival.repo.*;

import java.util.List;

@RestController
public class ApiControllers {

    @Autowired
    private userRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<user> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping(consumes = "application/json", value = "/save")
    public String saveUser(@RequestBody user user) {
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id , @RequestBody user user) {
        user updateUser = userRepo.findById(id).get();
        updateUser.setCountry(user.getCountry());
        updateUser.setName(user.getName());
        updateUser.setDepartment(user.getDepartment());
        userRepo.save(updateUser);
        return "Updated...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        user deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Delete User with the id: "+id;
    }
}
