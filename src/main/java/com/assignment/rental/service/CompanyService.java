package com.assignment.rental.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assignment.rental.model.Company;
import com.assignment.rental.repository.CompanyRepository;

@Service
@Transactional
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    public List<Company> get() {
        List<Company> company = new ArrayList<Company>();
        companyRepository.findAll().forEach(company::add);
        return company;
    }
}