package com.assignment.rental.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rental.model.Registered;
import com.assignment.rental.service.RegisterdService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class RegisterController {

    @Autowired
    RegisterdService registerdService;

    @PostMapping("/registration")
    public boolean saveQueue(@RequestBody Registered registered) {
        registered.setPickuptime(new Date());
        return registerdService.save(registered);
    }

    @GetMapping("/registration")
    public ResponseEntity<List<Registered>> get() {
        try {
            List<Registered> data = registerdService.get();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}