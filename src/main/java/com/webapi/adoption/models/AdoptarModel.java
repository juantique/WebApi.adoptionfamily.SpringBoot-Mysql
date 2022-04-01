package com.webapi.adoption.models;

import javax.persistence.*;

@Entity
@Table(name="adoptar")
public class AdoptarModel {

//Atributos del Modelo
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idadopcion;
	
	//IdNino - IdPadre - IdMadre 
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns(
			value = {
					@JoinColumn(name="idinfante", referencedColumnName="idpersona"),
					@JoinColumn(name="idpadre", referencedColumnName="idpersona"),
					@JoinColumn(name="idmadre", referencedColumnName="idpersona")
			},
			foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT)
	)
	PersonaModel persona;
	
	//@JoinColumns({
		//@JoinColumn(name="idinfante", referencedColumnName="idpersona"),
		//@JoinColumn(name="idpadre", referencedColumnName="idpersona"),
		//@JoinColumn(name="idmadre", referencedColumnName="idpersona")
	//})
	
	
	@Column(name = "visitaicbf")
	private Boolean visitaicbf;
	
	@Column(name = "salario")
	private Double salario;

//Generacion Get - Set	
	
	public Long getIdadopcion() {
		return idadopcion;
	}

	public void setIdadopcion(Long idadopcion) {
		this.idadopcion = idadopcion;
	}

	public PersonaModel getPersona() {
		return persona;
	}

	public void setPersona(PersonaModel persona) {
		this.persona = persona;
	}

	public Boolean getVisitaicbf() {
		return visitaicbf;
	}

	public void setVisitaicbf(Boolean visitaicbf) {
		this.visitaicbf = visitaicbf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	

	
	
	
	
}
