package com.example.WynajemRest.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mieszkanie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nazwa;
	
	private int cenaJednostkowa;
	
	private int powierzchnia;
	
	private String opis;
	
	@OneToMany(mappedBy="mieszkanie_nazwa", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	private List<Rezerwacja> rezerwacjeMieszkania;
	
	public Mieszkanie() {
	}

	public String getOpis() {
		return opis;
	}


	public void setOpis(String opis) {
		this.opis = opis;
	}



	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public int getCenaJednostkowa() {
		return cenaJednostkowa;
	}

	public void setCenaJednostkowa(int cenaJednostkowa) {
		this.cenaJednostkowa = cenaJednostkowa;
	}

	public int getPowierzchnia() {
		return powierzchnia;
	}

	public void setPowierzchnia(int powierzchnia) {
		this.powierzchnia = powierzchnia;
	}

}
