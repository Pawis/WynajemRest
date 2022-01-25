package com.example.WynajemRest.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rezerwacja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate okresPoczatek;
	
	private LocalDate okresKoniec;

	@ManyToOne
    @JoinColumn(name="mieszkania", nullable=false)
	private Osoba wynajmujaca_id;
	
	@ManyToOne
    @JoinColumn(name="rezerwacjeOsoby", nullable=false)
	private Osoba Najemca_id;

	private int koszt;
	
	@ManyToOne
    @JoinColumn(name="rezerwacjeMieszkania", nullable=false)
	private Mieszkanie mieszkanie_nazwa;
	
	public Mieszkanie getName() {
		return mieszkanie_nazwa;
	}

	public void setName(Mieszkanie name) {
		this.mieszkanie_nazwa = name;
	}

	public Rezerwacja() {
		
	}

	public LocalDate getOkresNajmuPoczatek() {
		return okresPoczatek;
	}

	public void setOkresNajmuPoczatek(LocalDate okresNajmuPoczatek) {
		this.okresPoczatek = okresNajmuPoczatek;
	}

	public LocalDate getOkresNajmuKoniec() {
		return okresKoniec;
	}

	public void setOkresNajmuKoniec(LocalDate okresNajmuKoniec) {
		this.okresKoniec = okresNajmuKoniec;
	}

	public Osoba getWynajmujaca_id() {
		return wynajmujaca_id;
	}

	public void setWynajmujaca_id(Osoba wynajmujaca_id) {
		this.wynajmujaca_id = wynajmujaca_id;
	}

	public Osoba getNajemca_id() {
		return Najemca_id;
	}

	public void setNajemca_id(Osoba najemca_id) {
		Najemca_id = najemca_id;
	}

	public int getKoszt() {
		return koszt;
	}

	public void setKoszt(int koszt) {
		this.koszt = koszt;
	}

	

}
