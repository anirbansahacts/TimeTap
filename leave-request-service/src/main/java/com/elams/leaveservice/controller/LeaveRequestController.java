package com.elams.leaveservice.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.elams.leaveservice.dto.LeaveHistoryResponseDTO;
import com.elams.leaveservice.dto.LeaveRequestDTO;
import com.elams.leaveservice.entity.LeaveRequest;
import com.elams.leaveservice.service.LeaveRequestService;
 
@RestController
@RequestMapping("/api/v1/employee/leave")
@RequiredArgsConstructor
public class LeaveRequestController {
 
    private final LeaveRequestService leaveService;
 
    @PostMapping("/request")
    public ResponseEntity<String> applyLeave(@Valid @RequestBody LeaveRequestDTO dto) {
        LeaveRequest leave = leaveService.submitLeaveRequest(dto);
        return ResponseEntity.ok("Leave request submitted. ID: " + leave.getLeaveId());
    }
    
    @GetMapping("/leave-history/{employeeId}")
    public ResponseEntity<List<LeaveHistoryResponseDTO>> getLeaveHistory(@PathVariable String employeeId) {
        return ResponseEntity.ok(leaveService.getLeaveHistoryByEmployeeId(employeeId));
    }
    
   
}
