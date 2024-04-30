package com.example.carparkproject.entity;

import com.example.carparkproject.enums.Department;
import com.example.carparkproject.validation.StrongPassword;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;

    @NotBlank
    private String account;
    //enum {HRM, STAFF}
    @NotNull
    private Department department;
    @NotBlank
    private String employeeAddress;
    @NotNull
    private LocalDate employeeBirthday;
    @NotBlank
    private String employeeEmail;
    @NotBlank
    private String employeeName;
    @NotBlank
    private String employeePhone;
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$", message = "Password must have at least 6 characters, including at least one uppercase letter, one lowercase letter, and one number")
    @StrongPassword
    private String password;
    @NotNull
    private byte sex;

    public Employee(String account, Department department, String employeeAddress, LocalDate employeeBirthday, String employeeEmail, String employeeName, String employeePhone, String password, byte sex) {
        this.account = account;
        this.department = department;
        this.employeeAddress = employeeAddress;
        this.employeeBirthday = employeeBirthday;
        this.employeeEmail = employeeEmail;
        this.employeeName = employeeName;
        this.employeePhone = employeePhone;
        this.password = password;
        this.sex = sex;
    }


}
