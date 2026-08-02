package com.medibook.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Objects;

/**
 * Represents a registered patient in the MediBook system.
 * 
 * <p>Patients must be between 0 (newborn) and 150 years of age.
 * Email address must be unique across all patients in the system.
 * Phone number must consist of exactly 10 numeric digits.</p>
 * 
 * Example usage:
 * <pre>
 *     Patient patient = new Patient("John Doe", "john@example.com", 30, "9876543210");
 *     patient.setMedicalHistory("No known allergies");
 * </pre>
 * 
 * @author MediBook Team
 * @version 1.0
 */
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Full legal name of the patient. Must not be blank (2 to 100 characters). */
    @NotBlank(message = "Patient name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    /** Unique email address used for notifications and identification. */
    @NotNull(message = "Email address cannot be null")
    @Email(message = "Invalid email format")
    @Column(unique = true, nullable = false)
    private String email;

    /** Patient age in years. Must be between 0 (newborn) and 150. */
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Age cannot exceed 150 years")
    private int age;

    /** Phone number: exactly 10 numeric digits. */
    @Pattern(regexp = "\\d{10}", message = "Phone must be exactly 10 digits")
    private String phone;

    /** Whether this patient account is active. Soft-delete flag. */
    private boolean active = true;

    /** Brief medical history notes. Optional. Maximum 1000 characters. */
    @Size(max = 1000, message = "Medical history cannot exceed 1000 characters")
    private String medicalHistory;

    /** Default no-argument constructor required by JPA. */
    public Patient() {
    }

    /**
     * Parameterized constructor for creating a Patient instance.
     * 
     * @param name Full legal name of the patient. Must not be blank.
     * @param email Unique email address. Must be a valid email format.
     * @param age Age in years (0 to 150).
     * @param phone 10-digit telephone number string.
     */
    public Patient(String name, String email, int age, String phone) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.active = true;
    }

    // Getters and Setters

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(id, patient.id) && Objects.equals(email, patient.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                '}';
    }
}
