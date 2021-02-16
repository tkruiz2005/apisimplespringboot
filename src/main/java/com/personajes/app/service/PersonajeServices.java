package com.personajes.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.personajes.app.entity.Personajes;


public interface PersonajeServices {
	
	public Iterable<Personajes> finAll(); 
	
	public Page<Personajes> finAll( Pageable pageable);
	
	public Optional<Personajes> findById(Long id);
	
	public Personajes create(Personajes personaje);
	
	public void deleteById(Long id);
	
	public ArrayList<Personajes>  findByNombreContaining(String nombre);

	public Personajes update(Personajes personajes);


}


