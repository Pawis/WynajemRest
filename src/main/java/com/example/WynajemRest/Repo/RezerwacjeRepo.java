package com.example.WynajemRest.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Rezerwacja;

@Repository
public interface RezerwacjeRepo extends CrudRepository<Rezerwacja, Integer> {

}
