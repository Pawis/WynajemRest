package com.example.WynajemRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WynajemRest.Repo.RezerwacjeRepo;
import com.example.WynajemRest.expection.RezerwacjaNaTaDateIstnieje;
import com.example.WynajemRest.model.Rezerwacja;

@Service
public class WynajemServiceImpl implements WynajemService {

	@Autowired
	private RezerwacjeRepo rezerwacjaRepo;

	public Rezerwacja dodajRezerwacje(Rezerwacja rezerwacja) throws RezerwacjaNaTaDateIstnieje {

		if (rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(rezerwacja.getOkres_Poczatek(), rezerwacja.getOkres_Koniec(),
				rezerwacja.getMieszkanie_nazwa().getNazwa()) == 0) {

			return rezerwacjaRepo.save(rezerwacja);
		} else
			throw new RezerwacjaNaTaDateIstnieje("Rezerwacja w tym okresie czasu juz istnieje");

	}

	@Override
	public Optional<Rezerwacja> zmianaRezerwacji(int id, Rezerwacja nowaRezerwacja) throws RezerwacjaNaTaDateIstnieje {

		Optional<Rezerwacja> rezerwacjaOpt = rezerwacjaRepo.findById(id);
		Rezerwacja rezerwacja = null;

		if (rezerwacjaOpt.isPresent()) {
			rezerwacja = rezerwacjaOpt.get();
			nowaRezerwacja.setId(rezerwacja.getId());
			if (rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(nowaRezerwacja.getOkres_Poczatek(),
					nowaRezerwacja.getOkres_Koniec(), nowaRezerwacja.getMieszkanie_nazwa().getNazwa()) == 0) {
				return Optional.of(rezerwacjaRepo.save(nowaRezerwacja));
			} else
				throw new RezerwacjaNaTaDateIstnieje("Rezerwacja w tym okresie czasu juz istnieje");
		}
		return Optional.empty();

	}

	@Override
	public List<Rezerwacja> listaRezerwacjiNajemcy(String nazwa) {

		List<Rezerwacja> rezerwacje = rezerwacjaRepo.listaRezerwacjiNajemcy(nazwa);
		return rezerwacje;
	}

	@Override
	public List<Rezerwacja> listaRezerwacjiMieszkania(String nazwa) {

		List<Rezerwacja> rezerwacje = rezerwacjaRepo.listaRezerwacjiMieszkania(nazwa);
		return rezerwacje;
	}

}
