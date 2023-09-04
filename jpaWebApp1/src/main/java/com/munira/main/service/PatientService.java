package com.munira.main.service;

import com.munira.main.exception.PatientNotFoundException;
import com.munira.main.model.Patient;
import com.munira.main.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    public List<Patient> getAllPatient(){
        return patientRepository.findAll();
    }

    public Patient getById(Integer id) throws PatientNotFoundException {
        return patientRepository.findById(id).orElseThrow(()->new PatientNotFoundException("Patient not found!"));
    }

//    public List<Patient> getByBlood(String bloodgroup){
//        return patientRepository.findByBloodContaining(bloodgroup);
//    }

    public List<Patient> getByBlood(String bloodgroup){
        return patientRepository.findByBloodBloodgroup(bloodgroup);
    }


    public void addPatient (Patient patient){
        patientRepository.save(patient);
    }

    public void updatePatient(Patient patient) throws PatientNotFoundException {
        if (!patientRepository.existsById(patient.getId())) {
            throw new PatientNotFoundException("Patient not found!");
        }
        patientRepository.saveAndFlush(patient);
    }

    public void deletePatientById(Integer id) throws PatientNotFoundException {
        if (!patientRepository.existsById(id)) {
            throw new PatientNotFoundException("Patient not found!");
        }
        patientRepository.deleteById(id);
    }
}
