package com.webapi.adoption.repositories;

import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;

import com.webapi.adoption.models.GeneroModel;

@Repository
public interface IGeneroRepository extends CrudRepository<GeneroModel, Long> {
	
}
