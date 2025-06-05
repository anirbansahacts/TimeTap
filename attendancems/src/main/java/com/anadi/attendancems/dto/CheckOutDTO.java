package com.anadi.attendancems.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class CheckOutDTO {
    private Long attendanceId;
    private LocalDate clockOutDate;
    private LocalTime clockOutTime;
    
    
}