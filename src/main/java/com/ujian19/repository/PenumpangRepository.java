package com.ujian19.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujian19.model.Penumpang;

public interface PenumpangRepository extends JpaRepository<Penumpang, String> {

	List<Penumpang> findByNik(String nik);
	
}
