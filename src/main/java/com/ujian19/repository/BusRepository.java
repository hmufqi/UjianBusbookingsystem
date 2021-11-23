package com.ujian19.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian19.model.Bus;

public interface BusRepository extends JpaRepository <Bus, Long> {
//	List<Bus> findByNomorpolisi(String nomor_polisi);
}
