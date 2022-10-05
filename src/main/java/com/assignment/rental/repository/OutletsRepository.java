package com.assignment.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.rental.model.Outlets;

public interface OutletsRepository extends JpaRepository<Outlets, Long> {
     List<Outlets> findByCompanyid(long companyid);
}