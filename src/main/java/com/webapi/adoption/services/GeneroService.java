package com.webapi.adoption.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapi.adoption.models.GeneroModel;
import com.webapi.adoption.repositories.IGeneroRepository;

@Service
public class GeneroService {
	
	//Ayuda a no instanciar el repositorio (El objeto trae todos los metodos desde la clase CRUDRepository)
	@Autowired
	IGeneroRepository iGeneroRepository;
	
	//Metodo Listar
	public ArrayList<GeneroModel> obtenerGeneros(){	
		return (ArrayList<GeneroModel>) iGeneroRepository.findAll();
	}
	
	//Metodo Guardar
	public GeneroModel guardarGenero(GeneroModel genero) {
		return iGeneroRepository.save(genero);
	}
	
	//Metodo Por ID:
	public GeneroModel obtenerPorId(Long id){
		return iGeneroRepository.findById(id).get();
	}
	
	//Metodo Actualizar
	public GeneroModel actualizarGenero(GeneroModel genero) {
		return iGeneroRepository.save(genero);
	}
	
	//Eliminar Usuario Por ID:
	public boolean eliminarGenero(Long id) {
		try {
			iGeneroRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}
	}
	
}
