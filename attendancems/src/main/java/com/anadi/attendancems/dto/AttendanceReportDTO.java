package com.anadi.attendancems.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceReportDTO {
	private long employeeId;
	private int totalWorkingDays;
	private int presentDays;
	private int absentDays;
	private double presentPercentage;
	private LocalTime avgClockIn;
	private LocalTime avgClockOut;
	private double avgWorkingHours;

}