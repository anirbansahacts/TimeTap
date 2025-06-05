package com.cts.backend.employeemicroservices.Repository;

import com.cts.backend.employeemicroservices.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    /**
     * Finds the manager ID for a given employee ID.
     * Uses a custom JPQL query to explicitly select only the 'managerId' column.
     *
     * @param employeeId The ID of the employee.
     * @return The manager's ID (Integer), or null if not found.
     */
    @Query("SELECT e.managerId FROM Employee e WHERE e.employeeId = :employeeId")
    Integer findManagerIdByEmployeeId(@Param("employeeId") int employeeId);

    /**
     * Finds the employee name for a given employee ID.
     * This can be used to find a manager's name if the provided ID is a manager's ID.
     * Uses a custom JPQL query to explicitly select only the 'employeeName' column.
     *
     * @param employeeId The ID of the employee (or manager).
     * @return The employee's name (String), or null if not found.
     */
    @Query("SELECT e.employeeName FROM Employee e WHERE e.employeeId = :employeeId")
    String findEmployeeNameByEmployeeId(@Param("employeeId") int employeeId);

    /**
     * Standard Spring Data JPA method to find an Employee by their ID.
     * Returns an Optional to handle cases where the employee might not exist.
     *
     * @param employeeId The ID of the employee.
     * @return An Optional containing the Employee object if found, otherwise an empty Optional.
     */
    Optional<Employee> findByEmployeeId(int employeeId);


}
