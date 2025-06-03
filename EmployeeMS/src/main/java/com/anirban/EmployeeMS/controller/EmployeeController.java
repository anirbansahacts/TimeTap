package com.anirban.EmployeeMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anirban.EmployeeMS.dto.EmployeeReportDTO;
import com.anirban.EmployeeMS.entity.Employee;
import com.anirban.EmployeeMS.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Employee>> findAllEmployees() {
		return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable long id) {
		Employee employee = employeeService.findEmployeeById(id);

		if (employee != null) {
			return new ResponseEntity<>(employee, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/report")
	public ResponseEntity<?> getEmployeeReport(@RequestParam long employeeId) {
		EmployeeReportDTO dto = employeeService.getEmployeeReport(employeeId);
		if (dto != null) {
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Error: Employee not found (or) Manager getting own data");
		}
	}
}
