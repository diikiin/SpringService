package com.company.service.work_with_files;

import com.company.service.model.Patient;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WriteIntoPDF {
    public static File getSickLeave(Patient patient) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(".\\files\\" + patient.getId() + ".pdf"));
        document.open();
        PdfPTable table = new PdfPTable(2);
        table.addCell(setHeader());

        String phrase = String.format("This sick leave is issued to a citizen %s %s identification number %d",
                patient.getFirstName(), patient.getLastName(), patient.getId());
        table.addCell(setCellColspan2(phrase));

        table.addCell(setCell("Reason for contacting a medical organization"));
        table.addCell(setCellAlignRight(patient.getComplaint()));

        table.addCell(setCell("Revealed diagnosis"));
        table.addCell(setCellAlignRight(patient.getDiagnosed()));

        table.addCell(setCell("Date of contacting to the medical organization"));
        LocalDate date = LocalDate.now().minusDays(3);
        table.addCell(setCellAlignRight(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));

        date = LocalDate.now();
        table.addCell(setCell(date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))));
        table.addCell(setCellAlignRight("City Polyclinic No. 5"));

        document.add(table);
        document.close();

        Files.createDirectories(Paths.get(".\\files"));
        return new File(".\\files\\" + patient.getId() + ".pdf");
    }

    private static PdfPCell setHeader() {
        PdfPCell header = new PdfPCell();
        header.setPhrase(new Phrase("Sick leave", new Font(Font.FontFamily.COURIER, 16, Font.BOLD)));
        header.setHorizontalAlignment(Element.ALIGN_CENTER);
        header.setPaddingBottom(20);
        header.setColspan(2);
        header.setBorder(Rectangle.NO_BORDER);
        return header;
    }

    private static PdfPCell setCell(String phrase) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase(phrase));
        cell.setPaddingBottom(20);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    private static PdfPCell setCellColspan2(String phrase) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase(phrase));
        cell.setColspan(2);
        cell.setPaddingBottom(20);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }

    private static PdfPCell setCellAlignRight(String phrase) {
        PdfPCell cell = new PdfPCell();
        cell.setPhrase(new Phrase(phrase));
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setPaddingBottom(20);
        cell.setBorder(Rectangle.NO_BORDER);
        return cell;
    }
}