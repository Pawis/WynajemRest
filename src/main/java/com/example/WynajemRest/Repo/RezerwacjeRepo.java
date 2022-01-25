package com.example.WynajemRest.Repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Rezerwacja;

@Repository
public interface RezerwacjeRepo extends CrudRepository<Rezerwacja, Integer> {
	
	//@Query(value ="select count(*) from wynajem.Rezerwacja where okres_poczatek <= :poczatek and  okres_koniec >= :koniec ", nativeQuery = true)
	@Query(value ="select count(*) from Rezerwacja as R join Mieszkanie as M on R.mieszkanie_nazwa=M.id where (R.okres_poczatek <= :poczatek and  R.okres_koniec >= :koniec) and M.nazwa =:MieszkanieNazwa", nativeQuery = true)
	public int rezerwacja(@Param(value = "poczatek") LocalDate poczatek,
			@Param(value = "koniec") LocalDate koniec, @Param(value = "MieszkanieNazwa") String MieszkanieNazwa);
}
