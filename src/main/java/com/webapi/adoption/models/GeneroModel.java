package com.webapi.adoption.models;

import javax.persistence.*;

@Entity
@Table(name="genero")
public class GeneroModel {
	
//Se crean las Propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long idgenero;
	
	@Column(name = "nombregenero")
	private String nombregenero;
	
//Generacion Get - Set
	public Long getIdGenero() {
		return idgenero;
	}

	public void setIdGenero(Long idGenero) {
		idgenero = idGenero;
	}

	public String getNombreGenero() {
		return nombregenero;
	}

	public void setNombreGenero(String nombreGenero) {
		nombregenero = nombreGenero;
	}
	
	
}
