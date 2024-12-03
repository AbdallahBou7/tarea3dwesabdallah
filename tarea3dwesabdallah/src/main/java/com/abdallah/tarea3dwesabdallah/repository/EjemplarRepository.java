package com.abdallah.tarea3dwesabdallah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdallah.tarea3dwesabdallah.modelo.Ejemplar;
import com.abdallah.tarea3dwesabdallah.modelo.Planta;
@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar,Long> {

	default Long ultimoIdEjemplarByPlanta(Planta p) {
		return 0L;
	}

	 

	
}
