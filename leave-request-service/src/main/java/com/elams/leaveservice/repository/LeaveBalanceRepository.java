package com.elams.leaveservice.repository;

import com.elams.leaveservice.entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
 
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Long> {
    Optional<LeaveBalance> findByEmployeeId(String employeeId);
}