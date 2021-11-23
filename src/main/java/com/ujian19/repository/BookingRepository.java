package com.ujian19.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian19.model.Booking;

public interface BookingRepository extends JpaRepository <Booking, Long> {

//	void deleteById(String id);

}
