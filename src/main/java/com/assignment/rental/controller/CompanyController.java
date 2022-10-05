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

import com.assignment.rental.model.Company;
import com.assignment.rental.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/companies")
    public ResponseEntity<List<Company>> get() {
        try {
            List<Company> data = companyService.get();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}