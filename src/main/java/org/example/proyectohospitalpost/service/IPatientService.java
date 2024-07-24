package org.example.proyectohospitalpost.service;

import org.example.proyectohospitalpost.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPatientService {
    Patient getPatient(long id);
    List<Patient> getAllPatients();
    Patient savePatient(Patient patient);
    Patient updatePatient(Patient patient);
    void deletePatientById(Long id);
    void deletePatient(Patient patient);

}
