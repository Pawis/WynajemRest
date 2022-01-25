package com.example.WynajemRest.Repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Rezerwacja;

@Repository
public interface RezerwacjeRepo extends CrudRepository<Rezerwacja, Integer> {
	
	//@Query(value ="select count(*) from wynajem.Rezerwacja where (okres_poczatek < :poczatek and  okres_poczatek < :koniec ) or"
	//		+ "  (okres_koniec > :poczatek and  okres_koniec > :koniec)", nativeQuery = true)
	@Query(value ="select count(*) from wynajem.Rezerwacja join mieszkanie on rezerwacja.mieszkanie_nazwa=mieszkanie.nazwa where (:poczatek between okres_poczatek and okres_koniec) or (:koniec between okres_poczatek and okres_koniec)", nativeQuery = true)
	public int rezerwacja(@Param(value = "poczatek") LocalDate poczatek,
			@Param(value = "koniec") LocalDate koniec);
}
