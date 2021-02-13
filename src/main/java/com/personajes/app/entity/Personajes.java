package com.personajes.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personajes")
public class Personajes implements Serializable{
	
	public Personajes() {
	}

	public Personajes(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	private static final long serialVersionUID = 3899384452610653080L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length=50, nullable=false, unique = true)
	private String nombre;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
