package com.munira.main.service;

import com.munira.main.model.Blood;
import com.munira.main.repository.BloodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodService {
    @Autowired
    private BloodRepository bloodRepository;

    public List<Blood> getAllBloodGroup(){
        return bloodRepository.findAll();
    }
}
