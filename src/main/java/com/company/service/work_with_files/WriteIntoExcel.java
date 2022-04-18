package com.company.service.work_with_files;

import com.company.service.model.Patient;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WriteIntoExcel {
    public static File getPatientList() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Patients");

        int rowNum = 0;
        Row rowHeader = sheet.createRow(rowNum);
        rowHeader.createCell(0).setCellValue("Id");
        rowHeader.createCell(1).setCellValue("First name");
        rowHeader.createCell(2).setCellValue("Last name");
        rowHeader.createCell(3).setCellValue("Birthday");
        rowHeader.createCell(4).setCellValue("Complaint");
        rowHeader.createCell(5).setCellValue("Diagnosed");

        DataFormat format = workbook.createDataFormat();
        CellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));

        List<Patient> patients = new ArrayList<>(Patient.getPatients());
        for (Patient patient : patients) {
            Row row = sheet.createRow(++rowNum);
            row.createCell(0).setCellValue(patient.getId());
            row.createCell(1).setCellValue(patient.getFirstName());
            row.createCell(2).setCellValue(patient.getLastName());
            row.createCell(3).setCellStyle(dateStyle);
            row.getCell(3).setCellValue(patient.getBirthday());
            row.createCell(4).setCellValue(patient.getComplaint());
            row.createCell(5).setCellValue(patient.getDiagnosed());
        }

        for (int i = 0; i < rowNum + 1; i++) {
            sheet.autoSizeColumn(i);
        }

        Files.createDirectories(Paths.get(".\\files"));
        workbook.write(new FileOutputStream(".\\files\\Patients list.xlsx"));
        workbook.close();
        return new File(".\\files\\Patients list.xlsx");
    }
}