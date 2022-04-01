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

import com.webapi.adoption.models.EstadoModel;
import com.webapi.adoption.services.EstadoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EstadoController {
	
	@Autowired
	EstadoService estadoService;
	
	//Get Listar Estados
	@GetMapping("/estado")
	public ArrayList<EstadoModel> obtenerEstados(){
		return estadoService.obtenerEstados();
	}
	
	//Guardar Estados
	@PostMapping("/estado")
	public EstadoModel guardarEstados(@RequestBody EstadoModel estado) {
		return this.estadoService.guardarEstado(estado);
	}
	
	//Anotacion Get Obtener por ID:
	@GetMapping(path = "/estado/{id}")
	public EstadoModel obtenerEstadoPorId(@PathVariable("id") Long id){
		return this.estadoService.obtenerEstadoPorId(id);
	}
		
	//Anotacion Delete:
	@DeleteMapping("/estado/{id}")
	public String eliminarGeneroPorId(@PathVariable(name = "id") Long id) {
		boolean ok = this.estadoService.eliminarEstado(id);
		if(ok) {
			return "Se elimino el Estado con id " + id;
		}else {
			return "No pudo eliminar el Estado con el id " + id;
		}
	}
		
	//Metodo Actualizar:
	@PutMapping(path = "/estado/{id}")
	public EstadoModel actualizarGenero(@PathVariable("id") Long id, @RequestBody EstadoModel estado) {
		EstadoModel estado_seleccionado = new EstadoModel();
		EstadoModel estado_actualizado = new EstadoModel();
			
		estado_seleccionado = estadoService.obtenerEstadoPorId(id);
		
		estado_seleccionado.setNombreEstado(estado.getNombreEstado());
					
		estado_actualizado = estadoService.actualizarEstado(estado_seleccionado);
					
		return estado_actualizado;
	}
}
