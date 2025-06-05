package com.elams.leaveservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
 
import java.time.LocalDate;

import com.elams.leaveservice.entity.LeaveType;
 
@Data
public class LeaveRequestDTO {
    @NotBlank
    private String employeeId;
    @NotNull
    private LeaveType leaveType;
    @NotNull
    private LocalDate leaveStartDate;
    @NotNull
    private LocalDate leaveEndDate;
    private String reason;
   
}
