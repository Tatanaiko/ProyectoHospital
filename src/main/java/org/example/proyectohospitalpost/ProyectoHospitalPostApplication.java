package org.example.proyectohospitalpost;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoHospitalPostApplication implements CommandLineRunner {

    private final static Logger LOG = LoggerFactory.getLogger(ProyectoHospitalPostApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProyectoHospitalPostApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
