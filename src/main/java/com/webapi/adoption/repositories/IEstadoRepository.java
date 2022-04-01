package com.webapi.adoption.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapi.adoption.models.EstadoModel;

@Repository
public interface IEstadoRepository extends CrudRepository<EstadoModel, Long>{

}
