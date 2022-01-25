package com.example.WynajemRest.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	public Optional<Rezerwacja> dodajRezerwacje(LocalDate poczatek, LocalDate koniec, String wynajmujacy,
			String najemca, int koszt, String mieszkanie) {

		if (rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(poczatek, koniec, mieszkanie) == 0) {
			Rezerwacja rezerwacja = new Rezerwacja();
			rezerwacja.setOkres_Poczatek(poczatek);
			rezerwacja.setOkres_Koniec(koniec);
			rezerwacja.setNajemca_id(osobaRepo.findByName(najemca));
			rezerwacja.setWynajmujaca_id(osobaRepo.findByName(wynajmujacy));
			rezerwacja.setMieszkanie_nazwa(mieszkanieRepo.findByName(mieszkanie));
			rezerwacja.setKoszt(koszt);
			Optional<Rezerwacja> rezerwacjaOptional = Optional.of(rezerwacjaRepo.save(rezerwacja));
			return rezerwacjaOptional;
		} else
			return Optional.empty();

	}

	/*
	 * @Override public Optional<Rezerwacja> zmianaRezerwacji(int id, LocalDate
	 * poczatek, LocalDate koniec, String wynajmujacy, String najemca, int koszt,
	 * String mieszkanie) {
	 * 
	 * Optional<Rezerwacja> rezerwacjaOptional = rezerwacjaRepo.findById(id);
	 * 
	 * if (rezerwacjaOptional.isPresent()) { Rezerwacja rezerwacja =
	 * rezerwacjaOptional.get(); rezerwacja.setKoszt(koszt);
	 * rezerwacja.setMieszkanie_nazwa(mieszkanieRepo.findByName(mieszkanie));
	 * rezerwacja.setNajemca_id(osobaRepo.findByName(najemca));
	 * rezerwacja.setWynajmujaca_id(osobaRepo.findByName(wynajmujacy));
	 * rezerwacja.setOkres_Poczatek(poczatek); rezerwacja.setOkres_Koniec(koniec);
	 * return Optional.of(rezerwacja);
	 * 
	 * } return rezerwacjaOptional;
	 * 
	 * }
	 */
	@Override
	public Rezerwacja zmianaRezerwacji(int id, Rezerwacja nowaRezerwacja) {
		
		System.out.println(nowaRezerwacja.getOkres_Koniec());
		
		Optional<Rezerwacja> rezerwacjaOpt = rezerwacjaRepo.findById(id);
		Rezerwacja rezerwacja = null;
System.out.println(id);
		if (rezerwacjaOpt.isPresent()) {
			
			rezerwacja=rezerwacjaOpt.get();
			rezerwacja.setId(id);
			rezerwacja.setKoszt(nowaRezerwacja.getKoszt());
			rezerwacja.setMieszkanie_nazwa(nowaRezerwacja.getMieszkanie_nazwa());
			rezerwacja.setNajemca_id(nowaRezerwacja.getNajemca_id());
			rezerwacja.setWynajmujaca_id(nowaRezerwacja.getWynajmujaca_id());
			rezerwacja.setOkres_Poczatek(nowaRezerwacja.getOkres_Poczatek());
			rezerwacja.setOkres_Koniec(nowaRezerwacja.getOkres_Koniec());
			
			Rezerwacja zaaktualizowanaRezerwacja = rezerwacjaRepo.save(rezerwacja);
			
			return zaaktualizowanaRezerwacja;
		}

		return null;

	}
}
