package com.example.demo.controllers;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.Profile;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(@Qualifier("s1") UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users/save")
    private void setUsers(
                         @RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam int age,
                         @RequestParam String mail,
                         @RequestParam String pass,
                         @RequestParam MultipartFile img){
        Profile profile = new Profile();
        profile.setFirstName(firstName);
        profile.setLastName(lastName);
        profile.setAge(age);
        profile.setUser(new User(mail,pass));
        profile.setImg(img.getOriginalFilename());
        userService.setImg(img);
        userService.save(profile);
    }

    @GetMapping("/users")
    private List<Profile> findUser(){
        return userService.findAll();
    }




}
