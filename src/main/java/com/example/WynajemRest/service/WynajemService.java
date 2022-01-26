package com.example.WynajemRest.service;

import java.util.List;
import java.util.Optional;

import com.example.WynajemRest.expection.RezerwacjaNaTaDateIstnieje;
import com.example.WynajemRest.model.Rezerwacja;

public interface WynajemService {
	
	public Rezerwacja dodajRezerwacje(Rezerwacja rezerwacja) throws RezerwacjaNaTaDateIstnieje;
	
	public Optional<Rezerwacja> zmianaRezerwacji(int id,Rezerwacja rezerwacja) throws RezerwacjaNaTaDateIstnieje;
	
	public List<Rezerwacja> listaRezerwacjiNajemcy(String nazwa);
	
	public List<Rezerwacja> listaRezerwacjiMieszkania(String nazwa);
}
