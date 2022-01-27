package com.example.WynajemRest.model;

import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.naming.NameNotFoundException;
import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
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

		long iloscDni = ChronoUnit.DAYS.between(rezerwacjaDTO.getOkres_poczatek(), rezerwacjaDTO.getOkres_koniec());

		Optional<Mieszkanie> mieszkanieOpt = mieszkaieRepo.findByName(rezerwacjaDTO.getMieszkanie());

		Optional<Osoba> najemca = osobaRepo.findByName(rezerwacjaDTO.getNajemca());

		Optional<Osoba> wynajmujaca = osobaRepo.findByName(rezerwacjaDTO.getWynajmujacy());

		Rezerwacja rezerwacja = new Rezerwacja();

		Mieszkanie mieszkanie = mieszkanieOpt.orElseThrow(() -> new NoSuchElementException("Nie znaleziono mieszkania"));
		
		rezerwacja.setKoszt((mieszkanie.getCenaJednostkowa() * mieszkanie.getPowierzchnia()) * iloscDni);
		rezerwacja.setMieszkanie_id(mieszkanie);
		rezerwacja.setNajemca_id(najemca.orElseThrow(() -> new NoSuchElementException("Nie znaleziono najemcy")));
		rezerwacja.setWynajmujaca_id(wynajmujaca.orElseThrow(() -> new NoSuchElementException("Nie znaleziono wynajmujacego")));

		rezerwacja.setOkres_Poczatek(rezerwacjaDTO.getOkres_poczatek());
		rezerwacja.setOkres_Koniec(rezerwacjaDTO.getOkres_koniec());

		return rezerwacja;

	}
}
