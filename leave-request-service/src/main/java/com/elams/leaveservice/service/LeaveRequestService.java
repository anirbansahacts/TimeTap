package com.elams.leaveservice.service;

import java.util.List;

import com.elams.leaveservice.dto.LeaveHistoryResponseDTO;
import com.elams.leaveservice.dto.LeaveRequestDTO;
import com.elams.leaveservice.entity.LeaveRequest;
 
public interface LeaveRequestService {
    LeaveRequest submitLeaveRequest(LeaveRequestDTO dto);
    List<LeaveHistoryResponseDTO> getLeaveHistoryByEmployeeId(String employeeId);
    LeaveRequest updateLeaveStatus(Long leaveId,String status);
}