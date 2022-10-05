package com.assignment.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.rental.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}