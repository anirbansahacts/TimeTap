package com.elams.leaveservice.entity;

import jakarta.persistence.*;
import lombok.*;
 
@Entity
@Table(name = "leave_balance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LeaveBalance {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String employeeId;
 
    private int totalLeaves = 15;
 
    private int usedLeaves = 0;
 
    public int getRemainingLeaves() {
        return totalLeaves - usedLeaves;
    }
}

