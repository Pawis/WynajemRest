package com.example.WynajemRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.WynajemRest.model.Mieszkanie;
import com.example.WynajemRest.model.Osoba;
import com.example.WynajemRest.model.Rezerwacja;

@SpringBootApplication
public class WynajemRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(WynajemRestApplication.class, args);
		
		Mieszkanie mieszkanie = new Mieszkanie();
		Osoba osoba1 = new Osoba();
		Osoba osoba2 = new Osoba();
		Rezerwacja rezerwacja = new Rezerwacja();
	}

}
