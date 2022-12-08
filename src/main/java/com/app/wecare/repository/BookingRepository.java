package com.app.wecare.repository;

import com.app.wecare.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query(value = "select count(*) from booking where user_id = :userId and booking_date = :bookingDate and ((start_time <= :startTime and end_time >= :endTime) or (start_time >= :startTime and start_time <= :endTime) " +
            "or (end_time >= :startTime and end_time <= :endTime))", nativeQuery = true)
    Long findCountBookingBetweenSlot(Long userId, LocalTime startTime, LocalTime endTime, LocalDate bookingDate);

    @Query(value = "select count(*) from booking where coach_id = :coachId and booking_date = :bookingDate and ((start_time <= :startTime and end_time >= :endTime) or (start_time >= :startTime and start_time <= :endTime) " +
            "or (end_time >= :startTime and end_time <= :endTime))", nativeQuery = true)
    Long findCoachAppointmentCountBookingBetweenSlot(Long coachId, LocalTime startTime, LocalTime endTime, LocalDate bookingDate);

    List<Booking> findAllByCoachId(Long coachId);
}
