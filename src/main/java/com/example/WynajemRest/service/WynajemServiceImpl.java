package com.example.WynajemRest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WynajemRest.Repo.RezerwacjeRepo;
import com.example.WynajemRest.model.Rezerwacja;

@Service
public class WynajemServiceImpl implements WynajemService {

	@Autowired
	private RezerwacjeRepo rezerwacjaRepo;

	public Optional<Rezerwacja> dodajRezerwacje(Rezerwacja rezerwacja) {

		if (rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(rezerwacja.getOkres_Poczatek(), rezerwacja.getOkres_Koniec(),
				rezerwacja.getMieszkanie_nazwa().getNazwa()) == 0) {

			Optional<Rezerwacja> rezerwacjaOptional = Optional.of(rezerwacjaRepo.save(rezerwacja));
			return rezerwacjaOptional;
			
		} else
			return Optional.empty();

	}

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
