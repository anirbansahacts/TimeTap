package com.anadi.attendancems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewAttendanceDTO {
	private long attendanceId;
	private long employeeId;
	private LocalDate clockInDate;
	private LocalDate clockOutDate;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;
    private double workHours;
}