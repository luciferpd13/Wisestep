package com.assignment.rental.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.assignment.rental.model.Outlets;
import com.assignment.rental.repository.OutletsRepository;

@Service
@Transactional
public class OutletsService {

    @Autowired
    OutletsRepository outletsRepository;

    public List<Outlets> getAll(long id) {
        List<Outlets> outlets = new ArrayList<Outlets>();
        outletsRepository.findByCompanyid(id).forEach(outlets::add);
        return outlets;
    }

    public List<Outlets> getAll() {
        List<Outlets> outlets = new ArrayList<Outlets>();
        outletsRepository.findAll().forEach(outlets::add);
        return outlets;
    }

}