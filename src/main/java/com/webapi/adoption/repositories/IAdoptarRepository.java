package com.webapi.adoption.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.webapi.adoption.models.AdoptarModel;

@Repository
public interface IAdoptarRepository extends CrudRepository<AdoptarModel, Long>{

}
