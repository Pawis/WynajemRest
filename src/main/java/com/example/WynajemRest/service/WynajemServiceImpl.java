package com.example.WynajemRest.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.WynajemRest.Repo.MieszkanieRepo;
import com.example.WynajemRest.Repo.OsobaRepo;
import com.example.WynajemRest.Repo.RezerwacjeRepo;
import com.example.WynajemRest.model.Rezerwacja;

@Service
public class WynajemServiceImpl implements WynajemService {

	@Autowired
	private OsobaRepo osobaRepo;
	@Autowired
	private MieszkanieRepo mieszkanieRepo;
	@Autowired
	private RezerwacjeRepo rezerwacjaRepo;

	@Async
	public Optional<Rezerwacja> dodajRezerwacje(LocalDate poczatek, LocalDate koniec, String wynajmujacy,
			String najemca, int koszt, String mieszkanie) {

		System.out.println(rezerwacjaRepo.rezerwacja(poczatek, koniec,mieszkanie));
		Optional<Rezerwacja> rezerwacjaOptional = null;
		if (rezerwacjaRepo.rezerwacja(poczatek, koniec,mieszkanie) == 0 ) {
			Rezerwacja rezerwacja = new Rezerwacja();
			rezerwacja.setOkres_Poczatek(poczatek);
			rezerwacja.setOkres_Koniec(koniec);
			rezerwacja.setNajemca_id(osobaRepo.findByName(najemca));
			rezerwacja.setWynajmujaca_id(osobaRepo.findByName(wynajmujacy));
			rezerwacja.setMieszkanie_nazwa(mieszkanieRepo.findByName(mieszkanie));
			rezerwacja.setKoszt(koszt);
			rezerwacjaOptional = Optional.of(rezerwacjaRepo.save(rezerwacja));
		} else
			return Optional.empty();

		return rezerwacjaOptional;

	}

}
