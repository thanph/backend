package com.example.demo.service;

import com.example.demo.entity.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ScheduleService {

    void changeSchedule(Schedule schedule);

    void deleteScheduleById(Integer id);

    List<Schedule> getAllSchedule();

    Schedule getScheduleById(Integer id);

    void createSchedule(int userId,String fullname, String phoneNumber, String note, LocalDate appointmentTime,Integer timeSlot);

    void confirmSchedule(Integer scheduleId);

    List<Schedule> getMyScheduleByUserId(Integer userId);

    List<Integer> getListTimeSlot(LocalDate ngayHen);
}
