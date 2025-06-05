package com.anadi.attendancems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anadi.attendancems.entity.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    
}