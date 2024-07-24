package org.example.proyectohospitalpost.controller;

import org.example.proyectohospitalpost.ProyectoHospitalPostApplication;
import org.example.proyectohospitalpost.entity.Patient;
import org.example.proyectohospitalpost.service.IPatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/patient")
public class PatientController implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(ProyectoHospitalPostApplication.class);

    @Autowired
    private IPatientService patientService;

    @GetMapping("getAll")
    public String getAllPatient(Model model) {
        LOG.info("Listando pacientes");
        List<Patient> patients = patientService.getAllPatients();
        if(patients.isEmpty()){
            LOG.error("Lista de pacientes vacía");
            model.addAttribute("error", "No existen pacientes");
        }
        model.addAttribute("pacientes", patients);
        return "patient";
    }

    @GetMapping("get/{id}")
    public String getPatient(Model model, Long id) {
        LOG.info("Obteniendo paciente con ID: " + id);
        Patient patient = patientService.getPatient(id);
        if(patient != null) {
            model.addAttribute("paciente", patient);
        } else {
            LOG.error("No existe paciente");
            model.addAttribute("error", "Paciente no encontrado");
        }
        return "patient/patient";
    }


    @Override
    public void run(String... args) throws Exception {
        LOG.info("Iniciando sistema");
    }
}
