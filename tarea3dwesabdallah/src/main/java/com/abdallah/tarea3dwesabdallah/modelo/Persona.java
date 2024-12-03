package com.abdallah.tarea3dwesabdallah.modelo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="personas")
public class Persona implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String nombre;
	
	@Column(unique=true)
	private String email;
	
	 
	 
	 
	 @OneToMany(mappedBy ="persona", cascade = CascadeType.ALL)
	 private List<Mensaje> mensajes;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	


	public List<Mensaje> getMensajes() {
		return mensajes;
	}


	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}
	 
	 
	 
	
	
	

}
