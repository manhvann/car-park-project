package com.example.carparkproject.dto;

import com.example.carparkproject.enums.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private long employeeId;
    private Department department;
    private String employeeAddress;
    private LocalDate employeeBirthday;
    private String employeeName;
    private String employeePhone;

}
