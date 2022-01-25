package com.example.WynajemRest.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Osoba;
@Repository
public interface OsobaRepo extends CrudRepository<Osoba, Integer> {

}
