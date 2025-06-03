package com.anirban.EmployeeMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anirban.EmployeeMS.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
