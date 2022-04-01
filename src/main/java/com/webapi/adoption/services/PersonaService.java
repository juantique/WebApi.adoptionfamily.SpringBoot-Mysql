package com.webapi.adoption.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapi.adoption.models.PersonaModel;
import com.webapi.adoption.repositories.IPersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	IPersonaRepository iPersonaRepository;
	
	//Metodo Listar
	public ArrayList<PersonaModel> obtenerPersonas(){	
		return (ArrayList<PersonaModel>) iPersonaRepository.findAll();
	}
		
	//Metodo Guardar
	public PersonaModel guardarPersona(PersonaModel persona) {
		return iPersonaRepository.save(persona);
	}
	
	//Metodo Por ID:
	public PersonaModel obtenerPersonaPorId(Long id){
		return iPersonaRepository.findById(id).get();
	}
		
	//Metodo Actualizar
	public PersonaModel actualizarPersona(PersonaModel persona) {
		return iPersonaRepository.save(persona);
	}
			
	//Eliminar Usuario Por ID:
	public boolean eliminarPersona(Long id) {
		try {
			iPersonaRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}
	}
}
