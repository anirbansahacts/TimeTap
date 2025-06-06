package com.elams.leaveservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elams.leaveservice.entity.LeaveRequest;
 
@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    boolean existsByEmployeeIdAndLeaveStartDateLessThanEqualAndLeaveEndDateGreaterThanEqual(
        String employeeId, java.time.LocalDate endDate, java.time.LocalDate startDate);
    List<LeaveRequest> findByEmployeeId(String employeeId);
   Optional<LeaveRequest> findByLeaveId(Long leaveId);
}