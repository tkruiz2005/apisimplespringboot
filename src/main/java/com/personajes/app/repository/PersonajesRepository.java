package com.personajes.app.repository;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import com.personajes.app.entity.Personajes;


@Repository
public interface PersonajesRepository extends JpaRepository <Personajes, Long>{

	 public abstract ArrayList<Personajes> findByNombreContaining(String nombre);
	
}
