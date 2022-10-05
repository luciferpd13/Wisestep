package com.assignment.rental.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assignment.rental.model.User;
import com.assignment.rental.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public List<User> get() {
        List<User> user = new ArrayList<User>();
        userRepository.findAll().forEach(user::add);
        return user;
    }

}