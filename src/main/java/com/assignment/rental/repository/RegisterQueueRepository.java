package com.assignment.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.rental.model.RegisterQueue;

public interface RegisterQueueRepository extends JpaRepository<RegisterQueue, Long> {
     RegisterQueue findByUseridAndOutletidAndVehicleid(long userid, long outletid, long vehicleid);
}