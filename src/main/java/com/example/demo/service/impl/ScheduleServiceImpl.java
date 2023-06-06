package com.example.demo.service.impl;

import com.example.demo.entity.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public void changeSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public void deleteScheduleById(Integer id) {
        scheduleRepository.deleteById(id);
    }

    @Override
    public List<Schedule> getAllSchedule() {
        List<Schedule> list = scheduleRepository.findAll();
        return list;
    }

    @Override
    public Schedule getScheduleById(Integer id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);
        if (optionalSchedule.isEmpty()) {
            return null;
        } else {
            return optionalSchedule.get();
        }
    }

    @Override
    public void createSchedule(int userId,String fullname, String phoneNumber, String note, LocalDate appointmentTime) {
        Schedule schedule = new Schedule();
        schedule.setUserId(userId);
        schedule.setFullname(fullname);
        schedule.setPhoneNumber(phoneNumber);
        schedule.setNote(note);
        schedule.setAppointmentTime(appointmentTime);
        schedule.setStatus(0);
        scheduleRepository.save(schedule);
    }

    @Override
    public void confirmSchedule(Schedule schedule) {
        schedule.setStatus(1);
        scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getMyScheduleByUserId(Integer userId) {
        List<Schedule> schedules = scheduleRepository.findScheduleByUserId(userId);
        return schedules;
    }
}