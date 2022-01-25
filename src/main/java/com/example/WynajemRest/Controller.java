package com.example.WynajemRest;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.WynajemRest.model.Rezerwacja;
import com.example.WynajemRest.service.WynajemService;

@RestController
public class Controller {

	@Autowired
	private WynajemService wynajemService;;

	@PostMapping("/post")
	public Rezerwacja sql(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate poczatekWynajmu,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate koniecWynajmu, String najemca,
			String wynajmujacy, int koszt, String mieszkanie) throws RezerwacjaNaTaDateIstnieje {

		Optional<Rezerwacja> rezerwacja = wynajemService.dodajRezerwacje(poczatekWynajmu, koniecWynajmu, najemca,
				wynajmujacy, koszt, mieszkanie);

		if (rezerwacja.isPresent()) {
			return rezerwacja.get();
		}
		throw new RezerwacjaNaTaDateIstnieje("Rezerwacja w tym okresie czasu juz istnieje");

	}

}
