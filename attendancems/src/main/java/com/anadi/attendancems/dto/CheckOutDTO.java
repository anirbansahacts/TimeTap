package com.anadi.attendancems.dto;

import java.time.LocalTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckOutDTO {
	private long employeeId;
	private LocalTime clockOutTime;

}