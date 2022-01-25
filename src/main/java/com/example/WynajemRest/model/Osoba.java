package com.example.WynajemRest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Osoba {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nazwa;
	
	@OneToMany(mappedBy="wynajmujaca_id", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Rezerwacja> mieszkania;
	
	@OneToMany(mappedBy="Najemca_id", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Rezerwacja> rezerwacjeOsoby;

	public Osoba() {
	}
	

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String imie) {
		this.nazwa = imie;
	}

}
