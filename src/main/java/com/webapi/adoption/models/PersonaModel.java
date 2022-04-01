package com.webapi.adoption.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class PersonaModel {
//Se crean las Propiedades
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long idpersona;
		
	@Column(name = "nomcompleto")
	private String nomcompleto;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "numdocu")
	private String numdocu;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechanace;
	
	@Column(name = "edad")
	private int edad;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="idgenero", referencedColumnName="idgenero")		
	})
	GeneroModel genero;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name="idestado", referencedColumnName="idestado")		
	})
	EstadoModel estado;

//Generacion Get - Set
	public Long getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(Long idpersona) {
		this.idpersona = idpersona;
	}

	public String getNomcompleto() {
		return nomcompleto;
	}

	public void setNomcompleto(String nomcompleto) {
		this.nomcompleto = nomcompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNumdocu() {
		return numdocu;
	}

	public void setNumdocu(String numdocu) {
		this.numdocu = numdocu;
	}

	public Date getFechanace() {
		return fechanace;
	}

	public void setFechanace(Date fechanace) {
		this.fechanace = fechanace;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public GeneroModel getGenero() {
		return genero;
	}

	public void setGenero(GeneroModel genero) {
		this.genero = genero;
	}

	public EstadoModel getEstado() {
		return estado;
	}

	public void setEstado(EstadoModel estado) {
		this.estado = estado;
	}	
	
}
