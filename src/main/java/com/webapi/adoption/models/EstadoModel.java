package com.webapi.adoption.models;

import javax.persistence.*;

@Entity
@Table(name="estado")
public class EstadoModel {
	
//Se crean las Propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idestado;
		
	@Column(name = "nomestado")
	private String nomestado;
	
//Generacion Get - Set
	public Long getIdEstado() {
		return idestado;
	}

	public void setIdEstado(Long idEstado) {
		idestado = idEstado;
	}

	public String getNombreEstado() {
		return nomestado;
	}

	public void setNombreEstado(String nombreEstado) {
		nomestado = nombreEstado;
	}
	
	
	
}
