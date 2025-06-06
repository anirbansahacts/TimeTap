package com.elams.leaveservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elams.leaveservice.dto.LeaveApprovalDTO;
import com.elams.leaveservice.entity.LeaveRequest;
import com.elams.leaveservice.service.LeaveRequestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/manager/leave")
@RequiredArgsConstructor
public class ManagerLeaveController {
	private final LeaveRequestService leaveService;
	
	 @PutMapping("/approve/{leaveId}")
	    public ResponseEntity<String> updateLeaveStatus(
	            @PathVariable Long leaveId,
	            @RequestBody LeaveApprovalDTO dto) {
	        LeaveRequest updated = leaveService.updateLeaveStatus(leaveId, dto.getStatus());
	        return ResponseEntity.ok("Leave " + updated.getStatus().toLowerCase() + " successfully.");
	    }
	 
	 
}
