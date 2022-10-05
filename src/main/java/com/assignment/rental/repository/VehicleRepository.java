package com.assignment.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.rental.model.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
     List<Vehicle> findByOutletid(long outletid);
}