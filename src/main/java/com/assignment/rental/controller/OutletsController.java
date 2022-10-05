package com.assignment.rental.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.rental.model.Outlets;
import com.assignment.rental.service.OutletsService;

@RestController
@RequestMapping("/api")
public class OutletsController {

    @Autowired
    OutletsService outletsService;

    @GetMapping("/outlets/{id}")
    public ResponseEntity<List<Outlets>> get(@PathVariable("id") long companyid) {
        try {
            List<Outlets> outlets = outletsService.getAll(companyid);
            return new ResponseEntity<>(outlets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/outlets")
    public ResponseEntity<List<Outlets>> get() {
        try {
            List<Outlets> outlets = outletsService.getAll();
            return new ResponseEntity<>(outlets, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}