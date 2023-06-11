package com.example.demo.service.impl;

import com.example.demo.entity.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        Sort sort =
//                Sort.by("status").ascending();
        Sort.by(Sort.Direction.ASC, "status")
                .and(Sort.by(Sort.Direction.DESC, "createdAt"));// Hoặc Sort.by(fieldName).descending() nếu muốn sắp xếp giảm dần
        List<Schedule> list = scheduleRepository.findAll(sort);
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
    public void createSchedule(int userId,String fullname, String phoneNumber, String note, LocalDate appointmentTime,Integer timeSlot) {
        Schedule schedule = new Schedule();
        schedule.setUserId(userId);
        schedule.setFullname(fullname);
        schedule.setPhoneNumber(phoneNumber);
        schedule.setNote(note);
        schedule.setAppointmentTime(appointmentTime);
        schedule.setStatus(0);
        schedule.setTimeSlot(timeSlot);
        scheduleRepository.save(schedule);
    }

    @Override
    public void confirmSchedule(Integer scheduleId) {
      Optional<Schedule> optionalSchedule =  scheduleRepository.findById(scheduleId);
      Schedule schedule = optionalSchedule.get();
      schedule.setStatus(1);
        scheduleRepository.save(schedule);
    }

    @Override
    public List<Schedule> getMyScheduleByUserId(Integer userId) {
        Sort sort = Sort.by("status").ascending();
        List<Schedule> schedules = scheduleRepository.findScheduleByUserId(sort,userId);
        return schedules;
    }

    @Override
    public List<Integer> getListTimeSlot(LocalDate ngayHen) {
            List<Integer> integerList = scheduleRepository.findAllTimeSlotByNgayHen(ngayHen);

        return integerList;
    }
}