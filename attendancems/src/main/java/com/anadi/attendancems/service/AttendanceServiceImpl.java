package com.anadi.attendancems.service;

import com.anadi.attendancems.dto.CheckInDTO;
import com.anadi.attendancems.dto.CheckOutDTO;
import com.anadi.attendancems.dto.ViewAttendanceDTO;
import com.anadi.attendancems.entity.Attendance;
import com.anadi.attendancems.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public String checkIn(CheckInDTO checkInDTO) {
        Attendance attendance = new Attendance();
        attendance.setEmployeeId(checkInDTO.getEmployeeId());
        attendance.setClockInDate(LocalDate.now());
        attendance.setClockInTime(LocalTime.now());
        attendanceRepository.save(attendance);
        return "Employee checked in successfully.";
    }

    @Override
    public String checkOut(CheckOutDTO checkOutDTO) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(checkOutDTO.getAttendanceId());

        if (optionalAttendance.isEmpty()) {
            return "Attendance record not found.";
        }

        Attendance attendance = optionalAttendance.get();
        attendance.setClockOutDate(checkOutDTO.getClockOutDate());
        attendance.setClockOutTime(checkOutDTO.getClockOutTime());

        // Calculate work hours
        Duration duration = Duration.between(attendance.getClockInTime(), attendance.getClockOutTime());
        long hours = duration.toHours();
        attendance.setWorkHours(hours);

        attendanceRepository.save(attendance);
        return "Employee checked out successfully.";
    }

    @Override
    public ViewAttendanceDTO viewAttendance(Long id) {
        Optional<Attendance> optionalAttendance = attendanceRepository.findById(id);

        if (optionalAttendance.isEmpty()) {
            return null;
        }

        Attendance attendance = optionalAttendance.get();
        ViewAttendanceDTO dto = new ViewAttendanceDTO();
        dto.setClockInDate(attendance.getClockInDate());
        dto.setClockInTime(attendance.getClockInTime());
        dto.setClockOutDate(attendance.getClockOutDate());
        dto.setClockOutTime(attendance.getClockOutTime());
        dto.setWorkHours(attendance.getWorkHours());

        return dto;
    }

	//@Override
	//public AttendanceSummaryDTO getAttendanceSummary(Long employeeId) {
	//    List<Attendance> records = attendanceRepository.findByEmployeeId(employeeId);
	//
	//    AttendanceSummaryDTO summaryDTO = new AttendanceSummaryDTO();
	//    summaryDTO.setEmployeeId(employeeId);
	//    summaryDTO.setTotalDaysPresent(records.size());
	//
	//    long totalHours = 0;
	//    for (Attendance attendance : records) {
	//        totalHours += attendance.getWorkHours();
	//    }
	//
	//    summaryDTO.setTotalWorkHours(totalHours);
	//    return summaryDTO;
	//}
}