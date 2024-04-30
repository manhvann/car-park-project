package com.example.carparkproject.dto.mapper;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.entity.Employee;
import com.example.carparkproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO toDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setEmployeeName(employee.getEmployeeName());
        employeeDTO.setEmployeeAddress(employee.getEmployeeAddress());
        employeeDTO.setEmployeePhone(employee.getEmployeePhone());
        employeeDTO.setEmployeeBirthday(employee.getEmployeeBirthday());
        employeeDTO.setDepartment(employee.getDepartment());
        return employeeDTO;
    }

}
