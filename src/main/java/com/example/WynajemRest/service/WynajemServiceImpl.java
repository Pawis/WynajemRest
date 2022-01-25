package com.example.WynajemRest.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.WynajemRest.Repo.MieszkanieRepo;
import com.example.WynajemRest.Repo.OsobaRepo;
import com.example.WynajemRest.Repo.RezerwacjeRepo;
import com.example.WynajemRest.model.Mieszkanie;
import com.example.WynajemRest.model.Osoba;
import com.example.WynajemRest.model.Rezerwacja;

@Service
public class WynajemServiceImpl implements WynajemService {


	@Autowired
	private RezerwacjeRepo rezerwacjaRepo;
	
	public void dodajRezerwacje(String poczatek, String koniec,
			String wynajmujacy,String najemca,int koszt) {
		
		LocalDate poczatekOkresu = LocalDate.parse(poczatek);
		LocalDate koniecOkresu = LocalDate.parse(koniec);
		
		
		Mieszkanie mieszkanie = new Mieszkanie();
		mieszkanie.setCenaJednostkowa(1000);
		mieszkanie.setNazwa("Dom");
		mieszkanie.setPowierzchnia(10);
		mieszkanie.setOpis("Duzy Dom");
		Osoba najemcaDamian = new Osoba();
		najemcaDamian.setNazwa("najemcaDamian");
		Osoba wynajmujacyKrzysiek = new Osoba();
		wynajmujacyKrzysiek.setNazwa("wynajmujacyKrzysiek");
		Rezerwacja rezerwacja = new Rezerwacja();
		
		rezerwacja.setNajemca_id(najemcaDamian);
		rezerwacja.setWynajmujaca_id(wynajmujacyKrzysiek);
		rezerwacja.setName(mieszkanie);
		rezerwacja.setKoszt(100);
		rezerwacja.setOkres_Koniec(LocalDate.of(2000, 1, 2));
		rezerwacja.setOkres_Poczatek(LocalDate.of(2000, 1, 1));
		rezerwacja.setMieszkanie_nazwa(mieszkanie);
		
		rezerwacjaRepo.save(rezerwacja);
		
	}


}
