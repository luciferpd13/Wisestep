package com.assignment.rental.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assignment.rental.model.Registered;
import com.assignment.rental.model.DropOff;
import com.assignment.rental.repository.RegisterdRepository;
import com.assignment.rental.repository.DropOffRepository;

@Service
@Transactional
public class DropOffService {

    @Autowired
    RegisterdRepository registerdRepository;

    @Autowired
    DropOffRepository dropOffRepository;

    public void save(DropOff dropOff) {
         if(dropOff.isIsvehiclerecovered()){
            registerdRepository.deleteById(dropOff.getRegisteredid());
         }
        dropOffRepository.save(dropOff);
    }

    public void update(long id) {
        DropOff data = dropOffRepository.findById(id).get();
        if(data != null){
            data.setIsvehiclerecovered(true);
            registerdRepository.deleteById(data.getRegisteredid());
            dropOffRepository.save(data);
        }
    }

    public List<DropOff> get() {
        List<DropOff> dropoff = new ArrayList<DropOff>();
        dropOffRepository.findAll().forEach(dropoff::add);
        return dropoff;
    }
}