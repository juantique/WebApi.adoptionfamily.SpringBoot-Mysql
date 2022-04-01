package com.webapi.adoption.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapi.adoption.models.EstadoModel;
import com.webapi.adoption.repositories.IEstadoRepository;

@Service
public class EstadoService {
	
	//Ayuda a no instanciar el repositorio (El objeto trae todos los metodos desde la clase CRUDRepository)
	@Autowired
	IEstadoRepository iEstadoRepository;
	
	//Metodo Listar
	public ArrayList<EstadoModel> obtenerEstados(){	
		return (ArrayList<EstadoModel>) iEstadoRepository.findAll();
	}
		
	//Metodo Guardar
	public EstadoModel guardarEstado(EstadoModel estado) {
		return iEstadoRepository.save(estado);
	}
	
	//Metodo Por ID:
	public EstadoModel obtenerEstadoPorId(Long id){
		return iEstadoRepository.findById(id).get();
	}
	
	//Metodo Actualizar
	public EstadoModel actualizarEstado(EstadoModel estado) {
		return iEstadoRepository.save(estado);
	}
		
	//Eliminar Usuario Por ID:
	public boolean eliminarEstado(Long id) {
		try {
			iEstadoRepository.deleteById(id);
			return true;
		}catch(Exception err) {
			return false;
		}
	}
}
