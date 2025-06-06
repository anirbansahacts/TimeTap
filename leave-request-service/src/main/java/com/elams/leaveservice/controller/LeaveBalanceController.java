package com.elams.leaveservice.controller;
import com.elams.leaveservice.entity.LeaveBalance;
import com.elams.leaveservice.service.LeaveBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/v1/employee/leave-balance")
@RequiredArgsConstructor
public class LeaveBalanceController {
 
    private final LeaveBalanceService service;
 
    @GetMapping("/{employeeId}")
    public ResponseEntity<LeaveBalance> getBalance(@PathVariable String employeeId) {
        return ResponseEntity.ok(service.getLeaveBalanceByEmployeeId(employeeId));
    }
    @PutMapping("/reset-all")
    public ResponseEntity<String> resetAllLeaveBalances() {
        service.resetAllLeaveBalances();
        return ResponseEntity.ok("Leave balances reset for all employees.");
    }
}
