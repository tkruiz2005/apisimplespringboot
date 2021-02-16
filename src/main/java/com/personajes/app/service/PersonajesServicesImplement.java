package com.personajes.app.service;

import java.util.ArrayList;
import java.util.Optional;

import com.personajes.app.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.personajes.app.entity.Personajes;
import com.personajes.app.repository.PersonajesRepository;

import org.springframework.cache.annotation.Cacheable;

@Service
public class PersonajesServicesImplement implements PersonajeServices {

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
	@Cacheable("personajesquery")
	public ArrayList<Personajes> findByNombreContaining(String nombre) {

		/* Descomentar para probar cache
		try {
			Thread.sleep(1000*5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		return PersonajeRepository.findByNombreContaining(nombre);
	}


	@Override
	@Transactional
	public Personajes create(Personajes personajes) {

		return PersonajeRepository.save(personajes);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {

		Optional<Personajes> personajesDB = this.PersonajeRepository.findById(id);

		if(personajesDB.isPresent()) {
			PersonajeRepository.deleteById(id);
		}else {
			throw new ResourceNotFoundException("Super Heroe no encontrado : " + id);
		}
	}

	@Override
	public Personajes update(Personajes personajes) {

		Optional<Personajes> productDb = this.PersonajeRepository.findById(personajes.getId());

		if(productDb.isPresent()) {
			Personajes productUpdate = productDb.get();
			productUpdate.setId(personajes.getId());
			productUpdate.setNombre(personajes.getNombre());
			return PersonajeRepository.save(personajes);
		}else {
			throw new ResourceNotFoundException("Super Heroe no encontrado : " + personajes.getId());
		}
	}
}
