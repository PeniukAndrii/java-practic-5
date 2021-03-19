package com.example.demo.service;


import com.example.demo.models.Profile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {
    void setImg(MultipartFile img);
    void save(Profile profile);
    List<Profile> findAll();
}
