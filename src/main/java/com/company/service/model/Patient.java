package com.company.service.model;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private Calendar birthday;
    private String complaint;
    private String diagnosed;

    public Patient(Long id, String firstName, String lastName, Calendar birthday, String complaint, String diagnosed) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.complaint = complaint;
        this.diagnosed = diagnosed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDiagnosed() {
        return diagnosed;
    }

    public void setDiagnosed(String diagnosed) {
        this.diagnosed = diagnosed;
    }

    public static List<Patient> getPatients() {
        Patient patient1 = new Patient(770324752349L, "Abdul", "Berikov",
                new GregorianCalendar(1977, Calendar.MARCH, 24), "Nausea, fatigue", "Diabetes");
        Patient patient2 = new Patient(561119351938L, "Aliya", "Zaparova",
                new GregorianCalendar(1956, Calendar.NOVEMBER, 19), "Eye pain, eye redness", "Conjunctivitis");
        Patient patient3 = new Patient(990815756819L, "Bolat", "Almaskhan",
                new GregorianCalendar(1999, Calendar.AUGUST, 15), "Skull fracture, concussion", "Skull trauma");
        Patient patient4 = new Patient(120613659043L, "Sara", "Alieva",
                new GregorianCalendar(2012, Calendar.JUNE, 13), "Multiple fractures of the bones of the right hand",
                "Broken arm");
        Patient patient5 = new Patient(530629486927L, "Murat", "Ulubaiev",
                new GregorianCalendar(1953, Calendar.JUNE, 29), "Abdominal pain, nausea, weakness", "Stomach cancer");

        return Arrays.asList(patient1, patient2, patient3, patient4, patient5);
    }
}