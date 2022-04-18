package com.company.service.service;

import com.company.service.model.Patient;
import com.company.service.work_with_files.WriteIntoExcel;
import com.company.service.work_with_files.WriteIntoPDF;
import com.itextpdf.text.DocumentException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class PatientService {
    private final List<Patient> patients = Patient.getPatients();

    public File getPatientsList() throws IOException {
        return WriteIntoExcel.getPatientList();
    }

    public File getSickLeave(Long id) throws DocumentException, IOException {
        Patient patient = patients.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        return WriteIntoPDF.getSickLeave(patient);
    }
}