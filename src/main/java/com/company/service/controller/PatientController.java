package com.company.service.controller;

import com.company.service.service.PatientService;
import com.itextpdf.text.DocumentException;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {
    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * This GET request allow us to download
     * Excel file with all patient data
     * URL http://localhost:8080/patient/download_patients_list
     * @return HTTP response and Excel file to download
     * @throws IOException
     */
    @GetMapping("/download_patients_list")
    public ResponseEntity<Resource> downloadPatientsListExcel() throws IOException {
        File file = patientService.getPatientsList();
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }

    /**
     * This GET request allow us to download
     * PDF file of patient's sick leave
     * URL http://localhost:8080/patient/download_sick_leave?id=770324752349
     * @param id is ID number of patient
     * @return HTTP response and PDF file to download
     * @throws DocumentException
     * @throws IOException
     */
    @GetMapping("/download_sick_leave")
    public ResponseEntity<Resource> downloadSickLeavePdf(@RequestParam("id") Long id) throws DocumentException, IOException {
        File file = patientService.getSickLeave(id);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getName() + "\"")
                .body(resource);
    }
}