package com.elams.leaveservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.elams.leaveservice.dto.LeaveHistoryResponseDTO;
import com.elams.leaveservice.dto.LeaveRequestDTO;
import com.elams.leaveservice.entity.LeaveRequest;
import com.elams.leaveservice.exception.InvalidLeaveRequestException;
import com.elams.leaveservice.exception.LeaveNotFoundException;
import com.elams.leaveservice.repository.LeaveRequestRepository;
import com.elams.leaveservice.repository.NationalHolidayRepository;
import com.elams.leaveservice.service.LeaveRequestService;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
 
@Service
@RequiredArgsConstructor
@Slf4j
public class LeaveRequestServiceImpl implements LeaveRequestService {
 
    private final LeaveRequestRepository repository ;
    private final NationalHolidayRepository holidayRepo;
    
    
    @Override
    public List<LeaveHistoryResponseDTO> getLeaveHistoryByEmployeeId(String employeeId) {
        List<LeaveRequest> leaveRequests = repository.findByEmployeeId(employeeId);
 
log.info("Found {} leave requests for employeeId={}", leaveRequests.size(), employeeId);
 
        return leaveRequests.stream()
                .map(leave -> new LeaveHistoryResponseDTO(
                        leave.getLeaveId(),
                        leave.getLeaveType(),
                        leave.getLeaveStartDate(),
                        leave.getLeaveEndDate(),
                        leave.getReason(),
                        leave.getStatus(),
                        leave.getNoOfDays()
                ))
                .collect(Collectors.toList());
    }
 
    @Override
    public LeaveRequest submitLeaveRequest(LeaveRequestDTO dto) {
        if (dto.getLeaveStartDate().isAfter(dto.getLeaveEndDate())) {
            throw new InvalidLeaveRequestException("Start date must be before end date");
        }
 
        List<LocalDate> leaveDates = dto.getLeaveStartDate()
                .datesUntil(dto.getLeaveEndDate().plusDays(1))
                .collect(Collectors.toList());
        
        for (LocalDate date : leaveDates) {
        	 if (isWeekend(date)) {
                 throw new InvalidLeaveRequestException("Cannot apply for leave on weekend: " + date);
             }
        	 if (holidayRepo.existsByMonthAndDay(date.getMonthValue(), date.getDayOfMonth())) {
        	        throw new InvalidLeaveRequestException("Cannot apply for leave on holiday: " + date);
        	    }
        }
 
        if (repository.existsByEmployeeIdAndLeaveStartDateLessThanEqualAndLeaveEndDateGreaterThanEqual(
                dto.getEmployeeId(), dto.getLeaveEndDate(), dto.getLeaveStartDate())) {
            throw new InvalidLeaveRequestException("Leave request overlaps with existing leave");
        }
 
       
        LeaveRequest leave = LeaveRequest.builder()
                .employeeId(dto.getEmployeeId())
                .leaveType(dto.getLeaveType())
                .leaveStartDate(dto.getLeaveStartDate())
                .leaveEndDate(dto.getLeaveEndDate())
                .reason(dto.getReason())
                .status("PENDING")
                .noOfDays(leaveDates.size())
                .createdAt(LocalDate.now())
                .build();
 
log.info("Leave request created: {}", leave);
        return repository.save(leave);
    }
 
    private boolean isWeekend(LocalDate date) {
        return date.getDayOfWeek() == DayOfWeek.SATURDAY ||
               date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
    
    @Override
    public LeaveRequest updateLeaveStatus(Long leaveId, String status) {
        LeaveRequest leave = repository.findById(leaveId)
            .orElseThrow(() -> new LeaveNotFoundException("Leave ID not found: " + leaveId));
     
        if (!status.equalsIgnoreCase("APPROVED") && !status.equalsIgnoreCase("REJECTED")) {
            throw new IllegalArgumentException("Invalid status. Must be APPROVED or REJECTED.");
        }
     
        leave.setStatus(status.toUpperCase());
        return repository.save(leave);
    }
   

}