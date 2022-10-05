package com.assignment.rental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assignment.rental.model.Registered;
import com.assignment.rental.model.RegisterQueue;
import com.assignment.rental.repository.RegisterdRepository;
import com.assignment.rental.repository.RegisterQueueRepository;

@Service
@Transactional
public class RegisterdService {

    @Autowired
    RegisterdRepository registerdRepository;

    @Autowired
    RegisterQueueRepository registerQueueRepository;

    public boolean save(Registered registered) {
        RegisterQueue queue = registerQueueRepository.findByUseridAndOutletidAndVehicleid(registered.getUserid(), registered.getOutletid(), registered.getVehicleid());
        if(queue != null){
            registered.setPickuptime(new Date());
            long duration  = registered.getPickuptime().getTime() - queue.getRegisteredtime().getTime();
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            registerQueueRepository.deleteById(queue.getId());
            if(diffInMinutes <= 10){
                registerdRepository.save(registered);
                return true;
            }
            return false;
        }
        return false;
    }

    public List<Registered> get() {
        List<Registered> registered = new ArrayList<Registered>();
        registerdRepository.findAll().forEach(registered::add);
        return registered;
    }
}