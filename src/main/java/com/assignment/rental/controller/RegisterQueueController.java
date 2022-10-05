package com.assignment.rental.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.assignment.rental.model.RegisterQueue;
import com.assignment.rental.service.RegisterQueueService;

@RestController
@RequestMapping("/api")
public class RegisterQueueController {

    @Autowired
    RegisterQueueService registerQueueService;

    @PostMapping("/queue-registration")
    public boolean saveQueue(@RequestBody RegisterQueue registerQueue) {
        return registerQueueService.save(registerQueue);
    }

    @GetMapping("/queue-registration")
    public ResponseEntity<List<RegisterQueue>> get() {
        try {
            List<RegisterQueue> queue = registerQueueService.get();
            return new ResponseEntity<>(queue, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}