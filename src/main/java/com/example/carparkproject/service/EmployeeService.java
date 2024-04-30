package com.example.carparkproject.service;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.entity.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> viewEmployeeList();
    void addEmployee(Employee employee);
    boolean editEmployee(Employee employee);
    void deleteEmployee(long employeeId);
    Page<EmployeeDTO> findEmployeesWithPagingAndSortingMany(int offset,int pageSize, String... fields);

    Page<EmployeeDTO> findEmployeesBetweenAges(int offset, int pageSize,int ageStart, int ageEnd);
}
