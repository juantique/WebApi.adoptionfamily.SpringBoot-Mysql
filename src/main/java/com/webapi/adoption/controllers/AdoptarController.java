package com.webapi.adoption.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.adoption.models.AdoptarModel;
import com.webapi.adoption.services.AdoptarService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AdoptarController {
	
	@Autowired
	AdoptarService adoptarService;
	
	//Get Listar Estados
	@GetMapping("/adopcion")
	public ArrayList<AdoptarModel> obtenerAdoptados(){
		return adoptarService.obtenerAdoptados();
	}
		
	//Guardar Estados
	@PostMapping("/adopcion")
	public AdoptarModel guardarAdoptados(@RequestBody AdoptarModel adoptar) {
		return this.adoptarService.guardarAdoptados(adoptar);
	}
}
