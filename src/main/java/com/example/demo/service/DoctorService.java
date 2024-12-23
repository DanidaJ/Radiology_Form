package com.example.demo.service;

import com.example.demo.DTO.DoctorDTO;
import com.example.demo.entity.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public void register(DoctorDTO doctorDTO) {

      Doctor doctor = new Doctor();

        doctor.setId(doctorDTO.getId());
        doctor.setfName(doctorDTO.getfName());
        doctor.setsName(doctorDTO.getsName());
        doctor.setEmail(doctorDTO.getEmail());


        doctorRepository.save(doctor);
    }
    public void exportDoctorsToExcel() throws IOException {
        List<Doctor> doctors = doctorRepository.findAll();

        // Create a new workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Doctors");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("First Name");
        headerRow.createCell(2).setCellValue("Second Name");
        headerRow.createCell(3).setCellValue("Email");

        // Populate the sheet with doctor data
        int rowNum = 1;
        for (Doctor doctor : doctors) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(doctor.getId());
            row.createCell(1).setCellValue(doctor.getfName());
            row.createCell(2).setCellValue(doctor.getsName());
            row.createCell(3).setCellValue(doctor.getEmail());
        }

        // Write the Excel file to disk
        try (FileOutputStream fileOut = new FileOutputStream("doctors.xlsx")) {
            workbook.write(fileOut);
        } finally {
            workbook.close();
        }
    }

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public long getDoctorCount() {
        return doctorRepository.count();
    }
}



