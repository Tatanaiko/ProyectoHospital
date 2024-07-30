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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/edit/{id}")
    public String editPatient(@PathVariable Long id, Model model) {
        LOG.info("Editando paciente con ID: " + id);
        Patient patient = patientService.getPatient(id);
        if(patient != null) {
            model.addAttribute("patient", patient);
            return "newPatient";
        } else {
            LOG.error("No existe paciente");
            model.addAttribute("error", "Paciente no encontrado");
        }
        return "newPatient";
    }

    @GetMapping("/newPatient")
    public String createPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "newPatient";
    }

    @PostMapping("/savePatient")
    public String savePatient(@ModelAttribute("patient") Patient patient){
        if(patient.getId() !=null){
            LOG.info("Actualizando nuevo paciente" );
        }else{
            LOG.info("Creando nuevo Paciente");
        }
        patientService.savePatient(patient);
        return "redirect:/patient/getAll";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        LOG.warn("Eliminando paciente con ID: " + id);
        patientService.deletePatientById(id);
        return "redirect:/patient/getAll";
    }

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Iniciando sistema");
    }
}
