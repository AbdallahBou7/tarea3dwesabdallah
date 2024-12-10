package com.abdallah.tarea3dwesabdallah.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.abdallah.tarea3dwesabdallah.modelo.*;

@Repository
public interface PlantaRepository extends JpaRepository<Planta,Long> {

	default boolean existeCodigo(Planta p) {
		List<Planta> listaplantas=findAll();
		for(Planta aux : listaplantas) {
			if (p.getCodigo().equals(aux.getCodigo()))
			return true;	
		}
		return false;
		
	}
	
	String findByCodigo(String codigo);

	Optional<Planta> findById(String codigo);

	List<Planta> listarPlantasOrdenadas();
	
	

}
