package com.anadi.attendancems.service;

import com.anadi.attendancems.dto.CheckInDTO;
import com.anadi.attendancems.dto.CheckOutDTO;
import com.anadi.attendancems.dto.ViewAttendanceDTO;

public interface AttendanceService {
    String checkIn(CheckInDTO checkInDTO);
    String checkOut(CheckOutDTO checkOutDTO);
    ViewAttendanceDTO viewAttendance(Long id);
}