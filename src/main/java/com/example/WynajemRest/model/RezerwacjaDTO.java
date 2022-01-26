package com.example.WynajemRest.model;

import java.time.LocalDate;



public class RezerwacjaDTO {
	
	private LocalDate okres_poczatek;
	
	private LocalDate okres_koniec;
	
	private String najemca;
	
	private String wynajmujacy;
	
	private int koszt;
	
	private String mieszkanie;
	
	

	public RezerwacjaDTO() {
	}

	public LocalDate getOkres_poczatek() {
		return okres_poczatek;
	}

	public void setOkres_poczatek(LocalDate okres_poczatek) {
		this.okres_poczatek = okres_poczatek;
	}

	public LocalDate getOkres_koniec() {
		return okres_koniec;
	}

	public void setOkres_koniec(LocalDate okres_koniec) {
		this.okres_koniec = okres_koniec;
	}

	public String getNajemca() {
		return najemca;
	}

	public void setNajemca(String najemca) {
		this.najemca = najemca;
	}

	public String getWynajmujacy() {
		return wynajmujacy;
	}

	public void setWynajmujacy(String wynajmujacy) {
		this.wynajmujacy = wynajmujacy;
	}

	public int getKoszt() {
		return koszt;
	}

	public void setKoszt(int koszt) {
		this.koszt = koszt;
	}

	public String getMieszkanie() {
		return mieszkanie;
	}

	public void setMieszkanie(String mieszkanie) {
		this.mieszkanie = mieszkanie;
	}
	
	
	
	
}
