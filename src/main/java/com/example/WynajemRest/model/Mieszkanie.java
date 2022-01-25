package com.example.WynajemRest.model;

import java.util.List;

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
	
	@OneToMany(mappedBy="mieszkanie_nazwa")
	private List<Rezerwacja> rezerwacjeMieszkania;
	
	private int rezerwacja_id;

	public Mieszkanie() {
	}
	
	public int getRezerwacja() {
		return rezerwacja_id;
	}

	public void setRezerwacja(int rezerwacja) {
		this.rezerwacja_id = rezerwacja;
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
