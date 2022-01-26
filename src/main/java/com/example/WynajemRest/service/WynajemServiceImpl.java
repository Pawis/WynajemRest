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
	public Optional<Rezerwacja> zmianaRezerwacji(int id, Rezerwacja nowaRezerwacja) {

		Optional<Rezerwacja> rezerwacjaOpt = rezerwacjaRepo.findById(id);
		Rezerwacja rezerwacja = null;

		if (rezerwacjaOpt.isPresent()) {
			rezerwacja = rezerwacjaOpt.get();
			nowaRezerwacja.setId(rezerwacja.getId());
			if (rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(nowaRezerwacja.getOkres_Poczatek(),
					nowaRezerwacja.getOkres_Koniec(), nowaRezerwacja.getMieszkanie_nazwa().getNazwa()) == 0) {
				return Optional.of(rezerwacjaRepo.save(nowaRezerwacja));
			} 
		} 
		return Optional.empty();

	}
}
