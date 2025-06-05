package com.cts.backend.employeemicroservices.services;

import com.cts.backend.employeemicroservices.Repository.EmployeeRepository;
import com.cts.backend.employeemicroservices.dto.EmployeeRequestDTO;
import com.cts.backend.employeemicroservices.dto.EmployeeResponseDTO;
import com.cts.backend.employeemicroservices.exception.ResourceNotFound;
import com.cts.backend.employeemicroservices.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    // Adding the employee or Manager
    public String addEmployeeOrManager(EmployeeRequestDTO employeeRequestDTO)
    {
         Employee employee =new Employee();
        employee.setEmployeeName(employeeRequestDTO.getEmployeeName());
        employee.setGender(employeeRequestDTO.getGender());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setContact(employeeRequestDTO.getContact());
        employee.setManagerId(employeeRequestDTO.getManagerId());
        employee.setRole(employeeRequestDTO.getRole());
        employee.setPassword("97474");

        employeeRepository.save(employee);
        return "Done";

    }

    // Viewing the profile details by employee id

   public EmployeeResponseDTO viewProfileById(int employeeId)
   {
     Employee employee=employeeRepository.findById(employeeId).orElseThrow(()->
             new ResourceNotFound("The employee not found")
     );

     return convertEmployeeResponseDTO(employee);
   }

   // viewing the all employee and manager profile

    public List<EmployeeResponseDTO> viewAllMemberProfile()
    {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream()
                .map(this::convertEmployeeResponseDTO)
                .collect(Collectors.toList());
    }

    public String getManagerNameForEmployee(int employeeId) {
        // Step 1: Find the managerId
        Integer managerId = employeeRepository.findManagerIdByEmployeeId(employeeId);

        if (managerId != null) {
            // Step 2: Use the managerId to find the manager's name
            return employeeRepository.findEmployeeNameByEmployeeId(managerId);
        }
        else {
            return "Id is only manager";
        }
    }

    private EmployeeResponseDTO convertEmployeeResponseDTO(Employee employee) {

        return new EmployeeResponseDTO(
                employee.getEmployeeId(),
                employee.getEmployeeName(),
                employee.getGender(),
                employee.getEmail(),
                employee.getContact(),
                employee.getManagerId(),
                employee.getRole()
        );
    }


}
