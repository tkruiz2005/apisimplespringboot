package com.personajes.app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.personajes.app.entity.Personajes;
import com.personajes.app.service.PersonajeServices;


@RestController
@RequestMapping("/api/personajes")

public class PersonajesController {

	@Autowired
	public PersonajeServices personajeService;

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Personajes personajes)
	{
		System.out.println("Begin Controller-create");
		Personajes oPersonaje = personajeService.create(personajes);

		
		return ResponseEntity.status(HttpStatus.CREATED).body(oPersonaje);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id)
	{
		System.out.println("Begin Controller-read");

		Optional<Personajes> oPersonaje = personajeService.findById(id);
		
		if (!oPersonaje.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oPersonaje);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Personajes personajesDetails, @PathVariable Long id)
	{
		System.out.println("Begin Controller-update");

		Optional<Personajes> oPersonajes = personajeService.findById(id);
		
		if (!oPersonajes.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		oPersonajes.get().setNombre(personajesDetails.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(personajeService.create(oPersonajes.get()));	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id)
	{
		System.out.println("Begin Controller-delete");

		Optional<Personajes> oPersonajes = personajeService.findById(id);
		
		if (!oPersonajes.isPresent())
		{
			return ResponseEntity.notFound().build();
		}
		
		personajeService.deleteById(id);		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Personajes> readAll()
	{
		System.out.println("Begin Controller-readAll");

		List<Personajes> users = StreamSupport
				.stream(personajeService.finAll().spliterator() , false)
				.collect(Collectors.toList());
			
		return users;
	}
	
	
	@GetMapping("/query")
    public ArrayList<Personajes> readPersonajeByName(@RequestParam("nombre") String nombre){

		System.out.println("Begin Controller-readAll");

        return this.personajeService.findByNombreContaining(nombre);
}

	
	
}
