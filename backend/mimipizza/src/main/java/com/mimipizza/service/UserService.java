package com.mimipizza.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import com.mimipizza.model.User;
import com.mimipizza.repository.UserRepository;

@Service
public class UserService {

    @Autowired UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    
    public Optional<User> findUserByID(String id){
        return userRepository.findById(id);
    }

    public void deleteUser(String id){
        userRepository.deleteById(id);
    }

}
