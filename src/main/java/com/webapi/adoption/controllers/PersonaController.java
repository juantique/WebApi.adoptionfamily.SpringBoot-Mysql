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

import com.webapi.adoption.models.PersonaModel;
import com.webapi.adoption.services.PersonaService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
	
	//Anotacion Tipo Get:
	@GetMapping("/persona")
	public ArrayList<PersonaModel> obtenerPersonas(){
		return personaService.obtenerPersonas();
	}
	
	//Anotacion Tipo Post Guardar:
	@PostMapping("/persona")
	public PersonaModel guardarPersona(@RequestBody PersonaModel persona) {
		return this.personaService.guardarPersona(persona);
	}
	
	//Anotacion Get Obtener por ID:
	@GetMapping(path = "/persona/{id}")
	public PersonaModel obtenerPersonaPorId(@PathVariable("id") Long id){
		return this.personaService.obtenerPersonaPorId(id);
	}
			
	//Anotacion Delete:
	@DeleteMapping("/persona/{id}")
	public String eliminarPersonaPorId(@PathVariable(name = "id") Long id) {
		boolean ok = this.personaService.eliminarPersona(id);
		if(ok) {
			return "Se elimino la Persona con id " + id;
		}else {
			return "No pudo eliminar la Persona con el id " + id;
		}
	}
			
	//Metodo Actualizar:
	@PutMapping(path = "/persona/{id}")
	public PersonaModel actualizarPersona(@PathVariable("id") Long id, @RequestBody PersonaModel persona) {
		PersonaModel persona_seleccionado = new PersonaModel();
		PersonaModel persona_actualizado = new PersonaModel();
			
		persona_seleccionado = personaService.obtenerPersonaPorId(id);
			
		persona_seleccionado.setNomcompleto(persona.getNomcompleto());
		persona_seleccionado.setEmail(persona.getEmail());
		persona_seleccionado.setUsuario(persona.getUsuario());
		persona_seleccionado.setNumdocu(persona.getNumdocu());
		persona_seleccionado.setFechanace(persona.getFechanace());
		persona_seleccionado.setEdad(persona.getEdad());
		persona_seleccionado.setGenero(persona.getGenero());
		persona_seleccionado.setEstado(persona.getEstado());
					
		persona_actualizado = personaService.actualizarPersona(persona_seleccionado);
					
		return persona_actualizado;
	}
}
