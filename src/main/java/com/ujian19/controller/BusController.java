package com.ujian19.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ujian19.model.Booking;
import com.ujian19.model.Bus;
import com.ujian19.model.Keberangkatan;
import com.ujian19.model.KeberangkatanDetail;
import com.ujian19.model.Penumpang;
import com.ujian19.repository.BookingRepository;
import com.ujian19.repository.BusRepository;
import com.ujian19.repository.KeberangkatanRepository;
import com.ujian19.repository.PenumpangRepository;

@RestController
@RequestMapping("/busbookingsystem")
public class BusController {
	@Autowired
	BookingRepository bookingRepo;
	
//	@Autowired
//	BusRepository busRepo;
//	
	@Autowired
	PenumpangRepository penumpangRepo;
	
	@Autowired
	KeberangkatanRepository keberangkatanRepo;
	
//	@GetMapping("/")
//	List<Bus> getData(@RequestBody Bus bus) {
//		return busRepo.findAll();
//	}
//	
	@PostMapping("/insertPenumpang")
	public String insertPenumpang(@RequestBody Penumpang penumpang ) {
	penumpangRepo.save(penumpang);
	return "Data penumpang berhasil ditambahkan";
	}
	
	@GetMapping("/getPenumpang/{nik}")
	public String getPenumpang(@PathVariable String nik){
		Optional<Penumpang> anu = penumpangRepo.findById(nik);
		 String message = "";
		 if (anu.isEmpty()) {
			 message = "Penumpang belum terdaftar, silahkan buat akun";
		 } else {
			 message = "Penumpang telah terdaftar";
		 }
		 return message;
	}
	
	@GetMapping("/findKeberangkatan")
	public List<KeberangkatanDetail> findKeberangkatan(@RequestParam(value="terminal_awal") String terminal_awal, @RequestParam(value="tanggal") String tanggal) {
	return keberangkatanRepo.getDetail(terminal_awal, tanggal);
	}
	
	@PostMapping("/booking")
	public String insertBooking(@RequestBody Booking booking) {
		bookingRepo.save(booking);
		return "Pemesanan bus berhasil";
	}
	
	@DeleteMapping("/cancel")
	public String deleteBooking(@RequestParam(value="id") long id) {
		bookingRepo.deleteById(id);
		return "Pemesanan dengan nomor id " + id + " telah dibatalkan";
	}

}
