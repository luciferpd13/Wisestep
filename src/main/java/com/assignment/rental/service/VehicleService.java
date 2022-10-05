package com.assignment.rental.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assignment.rental.model.Vehicle;
import com.assignment.rental.repository.VehicleRepository;

@Service
@Transactional
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    public List<Vehicle> getAll(long id) {
        List<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicleRepository.findByOutletid(id).forEach(vehicles::add);
        return vehicles;
    }

    public List<Vehicle> get() {
        List<Vehicle> vehicle = new ArrayList<Vehicle>();
        vehicleRepository.findAll().forEach(vehicle::add);
        return vehicle;
    }
}