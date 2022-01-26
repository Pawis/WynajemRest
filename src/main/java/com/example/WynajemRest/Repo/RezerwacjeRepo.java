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

	
	@Query(value = "select count(*) from Rezerwacja as R join Mieszkanie as M on R.mieszkanie_id=M.id "
			+ "where (R.okres_poczatek <= :poczatek and  R.okres_koniec >= :koniec) and M.nazwa =:MieszkanieNazwa", nativeQuery = true)
	public int czyKtosJuzWynajmujeWTymOkresie(@Param(value = "poczatek") LocalDate poczatek,
			@Param(value = "koniec") LocalDate koniec,
			@Param(value = "MieszkanieNazwa") String MieszkanieNazwa);
	
	@Query(value ="select * from Rezerwacja as R join Osoba as O on R.najemca_id=O.id where o.nazwa = :nazwa", nativeQuery= true)
	public List<Rezerwacja> listaRezerwacjiNajemcy(@Param("nazwa") String nazwa);
	
	@Query(value = "select * from Rezerwacja as R join Mieszkanie as M on R.mieszkanie_id=M.id where M.nazwa=:nazwa",nativeQuery=true)
	public List<Rezerwacja> listaRezerwacjiMieszkania(@Param("nazwa") String nazwa);
}
