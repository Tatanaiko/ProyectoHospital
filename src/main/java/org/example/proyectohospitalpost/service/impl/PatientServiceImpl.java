package org.example.proyectohospitalpost.service.impl;


import org.example.proyectohospitalpost.entity.Patient;
import org.example.proyectohospitalpost.repository.IPatientRepository;
import org.example.proyectohospitalpost.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    IPatientRepository patientRepository;
    @Override
    public Patient getPatient(long id) {
        Patient patient = patientRepository.findById(id).orElse(null);
        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);

    }

    @Override
    public void deletePatient(Patient patient) {
        patientRepository.delete(patient);
    }
}
