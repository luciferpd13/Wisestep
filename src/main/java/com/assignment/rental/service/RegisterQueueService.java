package com.assignment.rental.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assignment.rental.model.RegisterQueue;
import com.assignment.rental.model.Registered;
import com.assignment.rental.repository.RegisterQueueRepository;
import com.assignment.rental.repository.RegisterdRepository;

@Service
@Transactional
public class RegisterQueueService {

    @Autowired
    RegisterQueueRepository registerQueueRepository;

    @Autowired
    RegisterdRepository registerdRepository;

    public boolean save(RegisterQueue registerQueue) {
        RegisterQueue data = registerQueueRepository.findByUseridAndOutletidAndVehicleid(registerQueue.getUserid(), registerQueue.getOutletid(), registerQueue.getVehicleid());
        if(data != null){
            registerQueue.setRegisteredtime(new Date());
            long duration  = registerQueue.getRegisteredtime().getTime() - data.getRegisteredtime().getTime();
            long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
            if(diffInMinutes > 10){
                Registered isRiding = registerdRepository.findByUseridAndOutletidAndVehicleid(registerQueue.getUserid(), registerQueue.getOutletid(), registerQueue.getVehicleid());
                if(isRiding == null){
                    registerQueueRepository.save(registerQueue);
                    return true;
                }
                return false;
            }else{
                return false;
            }
        }
        Registered isRiding = registerdRepository.findByUseridAndOutletidAndVehicleid(registerQueue.getUserid(), registerQueue.getOutletid(), registerQueue.getVehicleid());
        if(isRiding == null){
            registerQueueRepository.save(registerQueue);
            return true;
        }
        return false;
    }

    public List<RegisterQueue> get() {
        List<RegisterQueue> registerQueue = new ArrayList<RegisterQueue>();
        registerQueueRepository.findAll().forEach(registerQueue::add);
        return registerQueue;
    }
}