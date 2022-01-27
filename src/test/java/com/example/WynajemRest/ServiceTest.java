package com.example.WynajemRest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.WynajemRest.Repo.RezerwacjeRepo;
import com.example.WynajemRest.model.Mieszkanie;
import com.example.WynajemRest.model.Osoba;
import com.example.WynajemRest.model.Rezerwacja;
import com.example.WynajemRest.service.WynajemServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@Mock
	private RezerwacjeRepo rezerwacjaRepo;

	@InjectMocks
	private WynajemServiceImpl wynajemServiceImpl;

	private Osoba najemca;
	private Osoba wynajmujacy;
	private Mieszkanie dom;
	private Rezerwacja rezerwacja;

	@BeforeEach
	public void init() {

		this.najemca = new Osoba();
		najemca.setNazwa("OsobaNajemca");
		this.wynajmujacy = new Osoba();
		wynajmujacy.setNazwa("OsobaWynajmujaca");

		this.dom = new Mieszkanie();
		dom.setCenaJednostkowa(10);
		dom.setNazwa("Dom");
		dom.setOpis("Super fajny dom");
		dom.setPowierzchnia(50);
		
		this.rezerwacja = new Rezerwacja();
		rezerwacja.setId(1);
		rezerwacja.setMieszkanie_id(dom);
		rezerwacja.setNajemca_id(najemca);
		rezerwacja.setWynajmujaca_id(wynajmujacy);
		rezerwacja.setOkres_Poczatek(LocalDate.parse("2000-01-01"));
		rezerwacja.setOkres_Koniec(LocalDate.parse("2000-01-15"));

	}

	@Test
	void testRezerwacjaPowinnoZwrocicRezerwacje() {

		when(wynajemServiceImpl.dodajRezerwacje(rezerwacja)).thenReturn(rezerwacja);

		Rezerwacja nowaRezerwacja = wynajemServiceImpl.dodajRezerwacje(rezerwacja);

		assertEquals(nowaRezerwacja.getId(), rezerwacja.getId());

	}

	@Test
	void testRezerwacjaNaTaDateJuzIstnieje() {

		when(rezerwacjaRepo.czyKtosJuzWynajmujeWTymOkresie(rezerwacja.getOkres_Poczatek(), rezerwacja.getOkres_Koniec(),
				"Dom")).thenReturn(1);
		
		
		assertThrows(IllegalArgumentException.class,() -> wynajemServiceImpl.dodajRezerwacje(rezerwacja));
		
		
	}

}
