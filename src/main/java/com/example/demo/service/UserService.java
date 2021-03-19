package com.example.demo.service;


import com.example.demo.models.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {
    void setUser(MultipartFile img);
    void save(User user);
    List<User> findAll();
}
