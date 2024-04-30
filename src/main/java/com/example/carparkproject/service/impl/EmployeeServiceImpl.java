package com.example.carparkproject.service.impl;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.dto.mapper.EmployeeMapper;
import com.example.carparkproject.entity.Employee;
import com.example.carparkproject.enums.Department;
import com.example.carparkproject.repository.EmployeeRepository;
import com.example.carparkproject.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeMapper employeeMapper;

    @PostConstruct
    public void initDB(){
        List<Employee> employees = IntStream.rangeClosed(1,200)
                .mapToObj(i->new Employee(
                        "Employee" + i,
                        Department.values()[(int) (Math.random() * Department.values().length)],
                        "Address" + i,
                        LocalDate.now().minusYears((long) (Math.random() * 30 + 20)),
                        "employee" + i + "@example.com",
                        "Employee Name" + i,
                        "123456789" + i,
                        "Password" + i,
                        (byte) (Math.random() * 2))).toList();
        employeeRepository.saveAll(employees);
    }

    @Override
    public List<EmployeeDTO> viewEmployeeList() {
        return employeeRepository.findAll()
                .stream()
                .map(x->employeeMapper.toDTO(x))
                .toList();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public boolean editEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getEmployeeId()) ){
            employeeRepository.save(employee);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void deleteEmployee(long employeeId) {
//        Employee employee = employeeRepository.findById(employeeId).get();
        employeeRepository.deleteById(employeeId);
    }

    //sort with one field

    @Override
    public Page<EmployeeDTO> findEmployeesWithPagingAndSortingMany(int offset,int pageSize, String... fields) {
        Sort sort = Sort.by(Arrays.stream(fields).map(Sort.Order::asc).toList());
        return employeeRepository.findAll(PageRequest.of(offset, pageSize,sort))
                .map(employeeMapper::toDTO);
    }

    //Find by age
    @Override
    public Page<EmployeeDTO> findEmployeesBetweenAges(int offset, int pageSize,int ageStart, int ageEnd) {
        LocalDate startDate = LocalDate.now().minusYears(ageEnd);
        LocalDate endDate = LocalDate.now().minusYears(ageStart);

        Sort sort = Sort.by(Sort.Direction.ASC, "employeeId");

        // Tìm kiếm và lọc những nhân viên có ngày sinh trong khoảng startDate và endDate
        return employeeRepository.findByEmployeeBirthdayBetween(startDate, endDate, PageRequest.of(offset, pageSize, sort))
                .map(employeeMapper::toDTO);
    }
}
