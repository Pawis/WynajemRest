package com.example.WynajemRest.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Mieszkanie;
@Repository
public interface MieszkanieRepo extends CrudRepository<Mieszkanie, Integer>{

}
