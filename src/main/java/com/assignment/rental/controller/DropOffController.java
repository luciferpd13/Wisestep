package com.assignment.rental.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rental.model.DropOff;
import com.assignment.rental.service.DropOffService;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class DropOffController {

    @Autowired
    DropOffService dropOffService;

    @PostMapping("/drop")
    public void save(@RequestBody DropOff dropOff) {
        dropOff.setDroptime(new Date());
        dropOffService.save(dropOff);
    }

    @PostMapping("/drop/{id}")
    public void update(@PathVariable("id") long id) {
         dropOffService.update(id);
    }

    @GetMapping("/drop")
    public ResponseEntity<List<DropOff>> get() {
        try {
            List<DropOff> queue = dropOffService.get();
            return new ResponseEntity<>(queue, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}