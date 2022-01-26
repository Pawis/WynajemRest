package com.example.WynajemRest.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.example.WynajemRest.Repo.MieszkanieRepo;
import com.example.WynajemRest.Repo.OsobaRepo;

@Component
public class Mapper {
	
	@Autowired
	private MieszkanieRepo mieszkaieRepo;
	@Autowired
	private OsobaRepo osobaRepo;
	
	@Async
	public Rezerwacja rezerwacjaDTOtoRezerwacja(RezerwacjaDTO rezerwacjaDTO) {
		
		Rezerwacja rezerwacja = new Rezerwacja();
		rezerwacja.setKoszt(rezerwacjaDTO.getKoszt());
		rezerwacja.setMieszkanie_nazwa(mieszkaieRepo.findByName(rezerwacjaDTO.getMieszkanie()));
		rezerwacja.setNajemca_id(osobaRepo.findByName(rezerwacjaDTO.getNajemca()));
		rezerwacja.setWynajmujaca_id(osobaRepo.findByName(rezerwacjaDTO.getWynajmujacy()));
		rezerwacja.setOkres_Poczatek(rezerwacjaDTO.getOkres_poczatek());
		rezerwacja.setOkres_Koniec(rezerwacjaDTO.getOkres_koniec());
		
		return rezerwacja;
		
	}

}
