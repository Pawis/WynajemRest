package com.example.WynajemRest.service;

import java.time.LocalDate;
import java.util.Optional;

import com.example.WynajemRest.model.Rezerwacja;

public interface WynajemService {
	
	public Optional<Rezerwacja> dodajRezerwacje(LocalDate poczatek, LocalDate koniec, String wynajmujacy,
			String najemca, int koszt, String mieszkanie);

}
