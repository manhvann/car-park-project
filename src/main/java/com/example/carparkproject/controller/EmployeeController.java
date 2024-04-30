package com.example.carparkproject.controller;

import com.example.carparkproject.dto.EmployeeDTO;
import com.example.carparkproject.entity.Employee;
import com.example.carparkproject.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDTO>> getList(){
        return ResponseEntity.ok().body(employeeService.viewEmployeeList());
    }

    @GetMapping("/employee/pageAndSortMany")
    public ResponseEntity<Page<EmployeeDTO>> getListWithPageAndSortMany(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int pageSize,@RequestParam(defaultValue = "employeeId") String... fields ){
        return ResponseEntity.ok().body(employeeService.findEmployeesWithPagingAndSortingMany(offset,pageSize,fields));
    }

    @GetMapping("/employee/findByAge")
    public ResponseEntity<Page<EmployeeDTO>> getListFindByAge(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "10") int pageSize,@RequestParam(defaultValue = "18") int ageStart, @RequestParam(defaultValue = "20") int ageEnd){
        return ResponseEntity.ok().body(employeeService.findEmployeesBetweenAges(offset,pageSize,ageStart,ageEnd));
    }

    @PostMapping("/employee")
    public ResponseEntity<?> post(@RequestBody @Valid Employee employee){
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Employee post Successfully", HttpStatus.OK);
    }

    @PutMapping("/employee")
    public void put(@RequestBody Employee employee){
        employeeService.editEmployee(employee);
    }

    @DeleteMapping("/employee")
    public void delete(@RequestParam long employeeID){
        employeeService.deleteEmployee(employeeID);
    }
}
