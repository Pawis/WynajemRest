package com.example.WynajemRest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.WynajemRest.Repo.RezerwacjeRepo;
import com.example.WynajemRest.expection.RezerwacjaNaTaDateIstnieje;
import com.example.WynajemRest.model.Rezerwacja;

@Service
public class WynajemServiceImpl implements WynajemService {

	private RezerwacjeRepo rezerwacjaRepo;
	
	public WynajemServiceImpl(RezerwacjeRepo rezerwacjaRepo) {
		this.rezerwacjaRepo= rezerwacjaRepo;
	}

	public Rezerwacja dodajRezerwacje(Rezerwacja rezerwacja) {

		if (rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(rezerwacja.getOkres_Poczatek(), rezerwacja.getOkres_Koniec(),
				rezerwacja.getMieszkanie_id().getNazwa()) == 0) {

			return rezerwacjaRepo.save(rezerwacja);
		} else
			throw new RezerwacjaNaTaDateIstnieje("Rezerwacja w tym okresie czasu juz istnieje");

	}

	@Override
	public Optional<Rezerwacja> zmianaRezerwacji(int id, Rezerwacja nowaRezerwacja) {

		Optional<Rezerwacja> rezerwacjaOpt = rezerwacjaRepo.findById(id);
		Rezerwacja rezerwacja = null;

		if (rezerwacjaOpt.isPresent()) {
			rezerwacja = rezerwacjaOpt.get();
			nowaRezerwacja.setId(rezerwacja.getId());
			if (rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(nowaRezerwacja.getOkres_Poczatek(),
					nowaRezerwacja.getOkres_Koniec(), nowaRezerwacja.getMieszkanie_id().getNazwa()) == 0) {
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
