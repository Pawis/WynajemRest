package com.example.WynajemRest.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Osoba;
@Repository
public interface OsobaRepo extends CrudRepository<Osoba, Integer> {
	
	@Query("from Osoba where nazwa=:imie")
	public Optional<Osoba> findByName(@Param("imie") String nazwa);
	

}
