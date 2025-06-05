package com.cts.backend.employeemicroservices.controller;

import com.cts.backend.employeemicroservices.dto.EmployeeRequestDTO;
import com.cts.backend.employeemicroservices.dto.EmployeeResponseDTO;
import com.cts.backend.employeemicroservices.model.Employee;
import com.cts.backend.employeemicroservices.services.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/v1/employee/create")
    public String addEmployeeOrManager(@Valid @RequestBody EmployeeRequestDTO employeeRequestDTO)
    {
        employeeService.addEmployeeOrManager(employeeRequestDTO);
        return "Done";
    }

    @GetMapping("v1/employee/{employeeId}")
    public EmployeeResponseDTO viewProfileById(@PathVariable int employeeId)
    {
        return employeeService.viewProfileById(employeeId);
    }

    @GetMapping("/v1/employee/alldetails")

    public List<EmployeeResponseDTO> viewAllDetails()
    {
        return employeeService.viewAllMemberProfile();
    }

    @GetMapping("/v1/{employeeId}")
    public String managerName(@PathVariable int employeeId)
    {
        return employeeService.getManagerNameForEmployee(employeeId);
    }

    @GetMapping("/csr")
    public CsrfToken get(HttpServletRequest req)
    {
        return (CsrfToken) req.getAttribute("_csrf");
    }


}
