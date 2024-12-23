package com.example.demo.controller;

import com.example.demo.DTO.DoctorDTO;
import com.example.demo.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;




    @PostMapping("/input")
    public ResponseEntity<String> registerDoctor(@RequestBody DoctorDTO doctorDTO) {
        try {
            doctorService.register(doctorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Doctor registered successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error registering doctor: " + e.getMessage());
        }

    }
    @PostMapping("/export")
    public ResponseEntity<String> exportDoctors() {
        try {
            doctorService.exportDoctorsToExcel();
            return ResponseEntity.ok("Doctors exported successfully to Excel!");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error exporting doctors: " + e.getMessage());
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getDoctorCount() {
        long count = doctorService.getDoctorCount();
        return ResponseEntity.ok(count);
    }
}