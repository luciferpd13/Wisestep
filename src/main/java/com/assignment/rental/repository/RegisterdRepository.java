package com.assignment.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.rental.model.Registered;

public interface RegisterdRepository extends JpaRepository<Registered, Long> {
    Registered findByUseridAndOutletidAndVehicleid(long userid, long outletid, long vehicleid);
}