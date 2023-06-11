package com.example.demo.repository;

import com.example.demo.entity.Schedule;
import com.example.demo.entity.UserEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    List<Schedule> findScheduleByUserId(Sort sort,Integer userId);
    @Query(value = "SELECT time_slot FROM schedule WHERE appointment_time = :appointmentTime",nativeQuery = true)
    List<Integer> findAllTimeSlotByNgayHen(@Param("appointmentTime") LocalDate appointmentTime);
}
