package com.example.WynajemRest.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	@Column(name = "okres_Poczatek")
	private LocalDate okres_Poczatek;
	
	@Column(name = "okres_Koniec")
	private LocalDate okres_Koniec;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name="wynajmujaca_id")
	private Osoba wynajmujaca_id;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name="Najemca_id")
	private Osoba Najemca_id;

	private int koszt;
	
	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
    @JoinColumn(name="mieszkanie_nazwa")
	private Mieszkanie mieszkanie_nazwa;

	
	public Mieszkanie getName() {
		return mieszkanie_nazwa;
	}

	public void setName(Mieszkanie name) {
		this.mieszkanie_nazwa = name;
	}

	public Rezerwacja() {
		
	}


	public LocalDate getOkres_Poczatek() {
		return okres_Poczatek;
	}

	public void setOkres_Poczatek(LocalDate okres_Poczatek) {
		this.okres_Poczatek = okres_Poczatek;
	}

	public LocalDate getOkres_Koniec() {
		return okres_Koniec;
	}

	public void setOkres_Koniec(LocalDate okres_Koniec) {
		this.okres_Koniec = okres_Koniec;
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

	public Mieszkanie getMieszkanie_nazwa() {
		return mieszkanie_nazwa;
	}

	public void setMieszkanie_nazwa(Mieszkanie mieszkanie_nazwa) {
		this.mieszkanie_nazwa = mieszkanie_nazwa;
	}

	

}
