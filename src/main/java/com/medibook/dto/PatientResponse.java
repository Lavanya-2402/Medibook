package com.medibook.dto;

import com.medibook.model.Patient;

/**
 * Data Transfer Object (DTO) representing a serialized Patient response.
 * 
 * @author MediBook Team
 * @version 1.0
 */
public class PatientResponse {

    private Long id;
    private String name;
    private String email;
    private int age;
    private String phone;
    private boolean active;
    private String medicalHistory;

    public PatientResponse() {
    }

    public PatientResponse(Patient patient) {
        this.id = patient.getId();
        this.name = patient.getName();
        this.email = patient.getEmail();
        this.age = patient.getAge();
        this.phone = patient.getPhone();
        this.active = patient.isActive();
        this.medicalHistory = patient.getMedicalHistory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}
