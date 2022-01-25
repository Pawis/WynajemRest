package com.example.WynajemRest.Repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.WynajemRest.model.Mieszkanie;

@Repository
public interface MieszkanieRepo extends CrudRepository<Mieszkanie, Integer>{

	@Query("from Mieszkanie where nazwa=:nazwa")
	public Mieszkanie findByName(@Param("nazwa")String nazwa); 
}
