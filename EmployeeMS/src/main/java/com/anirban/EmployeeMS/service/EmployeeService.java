package com.anirban.EmployeeMS.service;

import java.util.List;

import com.anirban.EmployeeMS.dto.EmployeeReportDTO;
import com.anirban.EmployeeMS.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);

	public List<Employee> findAllEmployees();

	public Employee findEmployeeById(long employeeId);

	public EmployeeReportDTO getEmployeeReport(long employeeId);
}
