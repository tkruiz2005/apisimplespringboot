package com.personajes.app.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personajes.app.entity.Personajes;
import com.personajes.app.repository.PersonajesRepository;

@Service
public class PersonajesServicesImplement implements PersonajeServices {


	@Override
	public ArrayList<Personajes> findByNombreContaining(String nombre) {
		// TODO Auto-generated method stub
		return PersonajeRepository.findByNombreContaining(nombre);
	}

	@Autowired
	private PersonajesRepository PersonajeRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Personajes> finAll() {
		return PersonajeRepository.findAll();
	}


	@Override
	@Transactional(readOnly=true)
	public Page<Personajes> finAll(Pageable pageable) {
		return PersonajeRepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Personajes> findById(Long id) {
		return PersonajeRepository.findById(id);
	}

	@Override
	@Transactional
	public Personajes create(Personajes personajes) {

		return PersonajeRepository.save(personajes);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		PersonajeRepository.deleteById(id);
	}
	
}
