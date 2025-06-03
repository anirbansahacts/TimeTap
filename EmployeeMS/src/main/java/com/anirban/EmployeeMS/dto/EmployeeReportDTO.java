package com.anirban.EmployeeMS.dto;

import com.anirban.EmployeeMS.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeReportDTO {
	private long employeeId;
	private String employeeName;
	private long contactNumber;
	private Role role;
	private String managerName;
}
