package com.example.WynajemRest.service;

import java.util.List;
import java.util.Optional;

import com.example.WynajemRest.model.Rezerwacja;

public interface WynajemService {
	
	public Optional<Rezerwacja >dodajRezerwacje(Rezerwacja rezerwacja);
	
	public Optional<Rezerwacja> zmianaRezerwacji(int id,Rezerwacja rezerwacja);
	
	public List<Rezerwacja> listaRezerwacjiNajemcy(String nazwa);
	
	public List<Rezerwacja> listaRezerwacjiMieszkania(String nazwa);
}
