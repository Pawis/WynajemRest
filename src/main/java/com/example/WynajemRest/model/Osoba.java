package com.example.WynajemRest.model;

import java.util.List;

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
	
	private String imie;
	
	@OneToMany(mappedBy="wynajmujaca_id")
	private List<Rezerwacja> mieszkania;
	
	@OneToMany(mappedBy="Najemca_id")
	private List<Rezerwacja> rezerwacjeOsoby;

	public Osoba() {
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

}
