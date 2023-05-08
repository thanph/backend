package com.example.demo.service;

import com.example.demo.entity.Schedule;

import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {

    void changeSchedule(Schedule schedule);

    void deleteScheduleById(Integer id);

    List<Schedule> getAllSchedule();

    Schedule getScheduleById(Integer id);

    void createSchedule(Integer userId, String phoneNumber, String note, LocalDateTime appointmentTime);

    void confirmSchedule(Schedule schedule);
}
