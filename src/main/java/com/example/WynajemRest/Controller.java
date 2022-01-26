package com.example.WynajemRest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	public Rezerwacja sql(@RequestBody RezerwacjaDTO rezerwacjaDTO) throws RezerwacjaNaTaDateIstnieje {
		
		if(rezerwacjaDTO.getOkres_koniec().isBefore(rezerwacjaDTO.getOkres_poczatek())) {
			throw new RezerwacjaNaTaDateIstnieje("Zle podany okres wynajmu");
		}
		
		Rezerwacja rezerwacja = mapper.rezerwacjaDTOtoRezerwacja(rezerwacjaDTO);

		Optional<Rezerwacja> rezerwacjaOpt = wynajemService.dodajRezerwacje(rezerwacja);

		if (rezerwacjaOpt.isPresent()) {
			return rezerwacjaOpt.get();
		}
		throw new RezerwacjaNaTaDateIstnieje("Rezerwacja w tym okresie czasu juz istnieje");

	}

	@PutMapping("/update/{id}")
	public Rezerwacja zmianaRezerwacji(@PathVariable int id, @RequestBody RezerwacjaDTO rezerwacjaDTO) throws RezerwacjaNaTaDateIstnieje {
		
		Rezerwacja rezerwacja = mapper.rezerwacjaDTOtoRezerwacja(rezerwacjaDTO);
		
		Optional<Rezerwacja> rezerwacjaOpt = wynajemService.zmianaRezerwacji(id, rezerwacja);
		if (rezerwacjaOpt.isPresent()) {
			return rezerwacjaOpt.get();
		}
		throw new RezerwacjaNaTaDateIstnieje("Rezerwacja w tym okresie czasu juz istnieje");
	}
	@GetMapping("/najemcy/{nazwa}")
	public List<Rezerwacja> listaRezerwacjiNajemca(@PathVariable String nazwa) {
		
		return wynajemService.listaRezerwacjiNajemcy(nazwa);
	}
	
	@GetMapping("/rezerwacjeMieszkania/{nazwa}")
	public  List<Rezerwacja> listaRezerwacjiMieszkania(@PathVariable String nazwa) {
		
		return wynajemService.listaRezerwacjiMieszkania(nazwa);
	}

}
