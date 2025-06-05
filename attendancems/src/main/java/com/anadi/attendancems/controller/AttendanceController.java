package com.anadi.attendancems.controller;

import com.anadi.attendancems.dto.CheckInDTO;
import com.anadi.attendancems.dto.CheckOutDTO;
import com.anadi.attendancems.dto.ViewAttendanceDTO;
import com.anadi.attendancems.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/checkin")
    public String checkIn(@RequestBody CheckInDTO checkInDTO) {
        return attendanceService.checkIn(checkInDTO);
    }

    @PostMapping("/checkout")
    public String checkOut(@RequestBody CheckOutDTO checkOutDTO) {
        return attendanceService.checkOut(checkOutDTO);
    }

    @GetMapping("/view/{id}")
    public ViewAttendanceDTO viewAttendance(@PathVariable Long id) {
        return attendanceService.viewAttendance(id);
    }
}