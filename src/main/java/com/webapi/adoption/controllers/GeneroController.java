package com.webapi.adoption.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapi.adoption.models.GeneroModel;
import com.webapi.adoption.services.GeneroService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
//Funciona de Manera API REST:
@RestController
//En que Direccion del Servidor se va activar la clase:
@RequestMapping("/api")
public class GeneroController {
	//Importa el Servicio creado:
	@Autowired
	GeneroService generoService;
	
	//Anotacion Tipo Get:
	@GetMapping("/genero")
	public ArrayList<GeneroModel> obtenerGeneros(){
		return generoService.obtenerGeneros();
	}
	
	//Anotacion Tipo Post:
	@PostMapping("/genero")
	public GeneroModel guardarGenero(@RequestBody GeneroModel genero) {
		return this.generoService.guardarGenero(genero);
	}
	
	//Anotacion Get Obtener por ID:
	@GetMapping(path = "/genero/{id}")
	public GeneroModel obtenerGeneroPorId(@PathVariable("id") Long id){
		return this.generoService.obtenerPorId(id);
	}
	
	//Anotacion Delete:
	@DeleteMapping("/genero/{id}")
	public String eliminarGeneroPorId(@PathVariable(name = "id") Long id) {
		boolean ok = this.generoService.eliminarGenero(id);
		if(ok) {
			return "Se elimino el Genero con id " + id;
		}else {
			return "No pudo eliminar el Genero con el id " + id;
		}
	}
	
	//Metodo Actualizar:
	@PutMapping(path = "/genero/{id}")
	public GeneroModel actualizarGenero(@PathVariable("id") Long id, @RequestBody GeneroModel genero) {
		GeneroModel genero_seleccionado = new GeneroModel();
		GeneroModel genero_actualizado = new GeneroModel();
				
		genero_seleccionado = generoService.obtenerPorId(id);
		
		genero_seleccionado.setNombreGenero(genero.getNombreGenero());
				
		genero_actualizado = generoService.actualizarGenero(genero_seleccionado);
				
		return genero_actualizado;
	}
	
}
