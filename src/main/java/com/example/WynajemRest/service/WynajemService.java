package com.example.WynajemRest.service;

import java.util.Optional;

import com.example.WynajemRest.model.Rezerwacja;

public interface WynajemService {
	
	public Optional<Rezerwacja >dodajRezerwacje(Rezerwacja rezerwacja);
	
	public Optional<Rezerwacja> zmianaRezerwacji(int id,Rezerwacja rezerwacja) ;
}
