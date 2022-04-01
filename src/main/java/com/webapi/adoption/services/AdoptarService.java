package com.webapi.adoption.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapi.adoption.models.AdoptarModel;
import com.webapi.adoption.repositories.IAdoptarRepository;

@Service
public class AdoptarService {
	
	@Autowired
	IAdoptarRepository iAdoptarRepository;
	
	//Metodo Listar
		public ArrayList<AdoptarModel> obtenerAdoptados(){	
			return (ArrayList<AdoptarModel>) iAdoptarRepository.findAll();
		}
		
		//Metodo Guardar
		public AdoptarModel guardarAdoptados(AdoptarModel adoptar) {
			return iAdoptarRepository.save(adoptar);
		}
}
