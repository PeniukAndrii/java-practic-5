package com.example.demo.service.implementation;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@AllArgsConstructor
@Service("s1")
public class UserServiceImplementationOne implements UserService{

    private UserDAO userDAO;

    @Override
    public void setUser(MultipartFile img){
        try {
            img.transferTo(new File(System.getProperty("user.home") + File.separator + "picture" + File.separator + img.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user){
        userDAO.save(user);
    }

    public List<User> findAll(){
        return userDAO.findAll();
    }
}
