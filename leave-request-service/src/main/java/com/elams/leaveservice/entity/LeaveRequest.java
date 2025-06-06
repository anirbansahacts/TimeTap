package com.elams.leaveservice.entity;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
 
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveRequest {
	
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="leave_id")
	    private Long leaveId;
	    
	 
	    private String employeeId;
	 
	    @Enumerated(EnumType.STRING)
	    @Column(name="leave_type",length=20)
	    private LeaveType leaveType;
	 
	    private LocalDate leaveStartDate;
	    private LocalDate leaveEndDate;
	 
	    private String reason;
	 
	    private String status; // PENDING,APPROVED,REJECTED
	 
	    private Integer noOfDays;
	 
	    private LocalDate createdAt;


	    
	
}
