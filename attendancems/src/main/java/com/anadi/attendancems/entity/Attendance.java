package com.anadi.attendancems.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attendanceId;

    @Column(nullable = false)
    private long employeeId;

    @Column(nullable = false)
    private LocalDate clockInDate;

    @Column(nullable = false)
    private LocalTime clockInTime;

    private LocalDate clockOutDate;

    private LocalTime clockOutTime;

    private double workHours;
}