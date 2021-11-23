package com.ujian19.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ujian19.model.Keberangkatan;
import com.ujian19.model.KeberangkatanDetail;

public interface KeberangkatanRepository extends JpaRepository <Keberangkatan, Long> {
	
	
	@Query(value="SELECT keberangkatan.id, jurusan.deskripsi, keberangkatan.tanggal as waktu, "
			+ "bus.nama_perusahaan as perusahaan, keberangkatan.kelas, keberangkatan.harga"
			+ " from keberangkatan"
			+ " INNER JOIN jurusan on keberangkatan.id_jurusan = jurusan.id"
			+ " INNER JOIN bus ON keberangkatan.no_polisi = bus.nomor_polisi"
			+ " where jurusan.terminal_awal = ?1 and keberangkatan.tanggal like ?2%"
			+ " and bus.kapasitas > (select count(*) from booking where booking.id_keberangkatan = keberangkatan.id)", nativeQuery = true)
	List<KeberangkatanDetail> getDetail(String terminal_awal, String tanggal);
}
