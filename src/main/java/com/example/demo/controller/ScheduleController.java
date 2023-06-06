package com.example.demo.controller;

import com.example.demo.entity.Schedule;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;


    @PostMapping("/dat-lich-kham")
    public void createSchedule(
            @RequestParam String userId,
            @RequestParam String fullname,
            @RequestParam String phoneNumber,
            @RequestParam String note,
            @RequestParam LocalDate appointmentTime) {
        scheduleService.createSchedule(Integer.parseInt(userId),fullname, phoneNumber, note, appointmentTime);
    }

    @PostMapping("/xac-nhan-lich-kham")
    public void confirmSchedule(@RequestBody Schedule schedule) {
        scheduleService.confirmSchedule(schedule);
    }

    @PutMapping("/sua-lich-kham")
    public void changeSchedule(@RequestBody Schedule schedule) {
        scheduleService.changeSchedule(schedule);
    }

    @DeleteMapping("/xoa-lich-kham/{id}")
    public void deleteScheduleById(@PathVariable Integer id) {
        scheduleService.deleteScheduleById(id);
    }

    @GetMapping("/ds-lich-kham")
    public List<Schedule> getAllSchedule() {
        return scheduleService.getAllSchedule();
    }

    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Integer id) {
        return scheduleService.getScheduleById(id);
    }

    @GetMapping("/my-schedule")
    public List<Schedule> getMySchedule(@RequestParam Integer userId){
        return scheduleService.getMyScheduleByUserId(userId);
    }
}
