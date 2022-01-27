package com.example.WynajemRest.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.WynajemRest.expection.ZlePodanyOkresCzasu;
import com.example.WynajemRest.model.Mapper;
import com.example.WynajemRest.model.Rezerwacja;
import com.example.WynajemRest.model.RezerwacjaDTO;
import com.example.WynajemRest.service.WynajemService;

@RestController
public class Controller {

	@Autowired
	private WynajemService wynajemService;

	@Autowired
	private Mapper mapper;

	@PostMapping("/post")
	public Rezerwacja tworzenieRezerwacji(@RequestBody RezerwacjaDTO rezerwacjaDTO) {

		if (rezerwacjaDTO.getOkres_koniec().isBefore(rezerwacjaDTO.getOkres_poczatek())) {
			throw new ZlePodanyOkresCzasu("Zle podany okres wynajmu");
		}

		Rezerwacja rezerwacja = mapper.rezerwacjaDTOtoRezerwacja(rezerwacjaDTO);

		return wynajemService.dodajRezerwacje(rezerwacja);


	}

	@PutMapping("/update/{id}")
	public Rezerwacja zmianaRezerwacji(@PathVariable int id, @RequestBody RezerwacjaDTO rezerwacjaDTO){

		Rezerwacja rezerwacja = mapper.rezerwacjaDTOtoRezerwacja(rezerwacjaDTO);

		Optional<Rezerwacja> rezerwacjaOpt = wynajemService.zmianaRezerwacji(id, rezerwacja);
		return rezerwacjaOpt.orElseThrow(() -> new NoSuchElementException("Nie ma takiej rezerwacji"));

	}

	@GetMapping("/najemcy/{nazwa}")
	public List<Rezerwacja> listaRezerwacjiNajemca(@PathVariable String nazwa) {

		return wynajemService.listaRezerwacjiNajemcy(nazwa);
	}

	@GetMapping("/rezerwacjeMieszkania/{nazwa}")
	public List<Rezerwacja> listaRezerwacjiMieszkania(@PathVariable String nazwa) {

		return wynajemService.listaRezerwacjiMieszkania(nazwa);
	}

}
