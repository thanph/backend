package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "note")
    private String note;

    @Column(name = "appointment_time")
    private LocalDate appointmentTime;

    @Column(name = "time_slot")
    private Integer timeSlot;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "status")
    private Integer status;
}
