package com.anirban.EmployeeMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anirban.EmployeeMS.dto.EmployeeReportDTO;
import com.anirban.EmployeeMS.entity.Employee;
import com.anirban.EmployeeMS.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findEmployeeById(long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public EmployeeReportDTO getEmployeeReport(long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).orElse(null);
		if (employee == null) {
			return null;
		} else {
			Employee manager = employeeRepository.findById(employee.getManagerId()).orElse(null);
			if (manager == null) {
				return null;
			}
			return new EmployeeReportDTO(employee.getEmployeeId(), employee.getEmployeeName(),
					employee.getContactNumber(), employee.getRole(), manager.getEmployeeName());
		}
	}

}
