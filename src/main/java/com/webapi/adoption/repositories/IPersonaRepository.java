package com.webapi.adoption.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapi.adoption.models.PersonaModel;

@Repository
public interface IPersonaRepository extends CrudRepository<PersonaModel, Long>{

}
