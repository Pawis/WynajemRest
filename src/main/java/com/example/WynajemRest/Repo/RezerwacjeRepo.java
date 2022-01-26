package com.example.WynajemRest.Repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Rezerwacja;

@Repository
public interface RezerwacjeRepo extends CrudRepository<Rezerwacja, Integer> {

	
	@Query(value = "select count(*) from Rezerwacja as R join Mieszkanie as M on R.mieszkanie_nazwa=M.id "
			+ "where (R.okres_poczatek <= :poczatek and  R.okres_koniec >= :koniec) and M.nazwa =:MieszkanieNazwa", nativeQuery = true)
	public int czyKtosJuzWynajmujeWTymOkresie(@Param(value = "poczatek") LocalDate poczatek,
			@Param(value = "koniec") LocalDate koniec, @Param(value = "MieszkanieNazwa") String MieszkanieNazwa);

	@Query(value = "update Rezerwacja as R set okres_poczatek=:poczatek, okres_koniec=:koniec, WYNAJMUJACA_ID=:wynajmujacy,NAJEMCA_ID=:najemca, koszt=:koszt,mieszkanie_nazwa=:mieszkanieId where id=:id", nativeQuery = true)
	public Rezerwacja zmianaRezerwacji(@Param(value="id")int id, @Param(value="poczatek")LocalDate poczatek,
			@Param(value="koniec") LocalDate koniec, @Param(value="wynajmujacy")String wynajmujacy,
			@Param(value="najemca")String najemca,@Param(value="koszt")int koszt, @Param(value="mieszkanieId")String mieszkanieId);
	
	@Query(value ="select * from Rezerwacja as R join Osoba as O on R.najemca_id=O.id where o.nazwa = :nazwa", nativeQuery= true)
	public List<Rezerwacja> listaRezerwacjiNajemcy(@Param("nazwa") String nazwa);
}
