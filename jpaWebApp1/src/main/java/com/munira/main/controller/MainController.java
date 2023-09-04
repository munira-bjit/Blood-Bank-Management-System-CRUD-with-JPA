package com.munira.main.controller;

import com.munira.main.exception.PatientNotFoundException;
import com.munira.main.model.Blood;
import com.munira.main.model.Patient;
import com.munira.main.service.BloodService;
import com.munira.main.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {


    @Autowired
    private PatientService patientService;

    @Autowired
    private BloodService bloodService;

    @GetMapping("/patient/all")
    public ResponseEntity<List<Patient>> getAllPatient() {
        List<Patient> patientList = patientService.getAllPatient();
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer id) throws PatientNotFoundException {
        Patient patient = patientService.getById(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping("/group/{bloodgroup}")
    public ResponseEntity<List<Patient>> getPatientByBlood(@PathVariable String bloodgroup) {
        List<Patient> patientList = patientService.getByBlood(bloodgroup);
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    @PostMapping("/save-patient")
    public ResponseEntity<String> savePatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return new ResponseEntity<>("Patient added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Integer id) throws PatientNotFoundException {
        patientService.deletePatientById(id);
        return new ResponseEntity<>("Patient deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/update-patient/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable Integer id, @RequestBody Patient patient) throws PatientNotFoundException {
        patientService.updatePatient(patient);
        return new ResponseEntity<>("Patient updated successfully", HttpStatus.OK);
    }

    @GetMapping("/bloodgroup/all")
    public ResponseEntity<List<Blood>> getAllBloodGroup() {
        List<Blood> groupList = bloodService.getAllBloodGroup();
        return new ResponseEntity<>(groupList, HttpStatus.OK);
    }

}
