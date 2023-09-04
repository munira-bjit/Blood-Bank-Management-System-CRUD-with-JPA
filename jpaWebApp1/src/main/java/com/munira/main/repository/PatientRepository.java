package com.munira.main.repository;

import com.munira.main.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {


//    List<Patient> findByBloodContaining(String bloodgroup);

    List<Patient> findByBloodBloodgroup(String bloodgroup);

}
