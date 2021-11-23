package com.ujian19.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy =	GenerationType.IDENTITY)
	private long id;
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "id_keberangkatan", referencedColumnName = "id")
//	private Keberangkatan id_keberangkatan;
	private long id_keberangkatan;
//	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "nik", referencedColumnName = "nik")
//	private Penumpang nik;
	private String nik;
	
	private String tanggal;
	private long id_jurusan;
	private String no_polisi;
	
	
//	@Id
//	@GeneratedValue(strategy =	GenerationType.IDENTITY)
//	private long id;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "idKeberangkatan", referencedColumnName = "id")
//	private Keberangkatan idKeberangkatan;
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "nik", referencedColumnName = "nik")
//	private Penumpang nik;
//
//	private String tanggal;
//
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "idJurusan", referencedColumnName = "id")
//	private Jurusan idJurusan;
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "nomorPolisi", referencedColumnName = "nomorPolisi")
//	private Bus noPolisi;
}
