package com.elams.leaveservice.dto;
import com.elams.leaveservice.entity.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
 
import java.time.LocalDate;
 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveHistoryResponseDTO {
	private Long leaveId;
    private LeaveType leaveType;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;
    private String reason;
    private String status;
    private Integer noOfDays;
}
