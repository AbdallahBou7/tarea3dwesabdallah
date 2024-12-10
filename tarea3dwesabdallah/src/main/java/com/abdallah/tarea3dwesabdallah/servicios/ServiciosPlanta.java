package com.abdallah.tarea3dwesabdallah.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdallah.tarea3dwesabdallah.modelo.Planta;
import com.abdallah.tarea3dwesabdallah.repository.EjemplarRepository;
import com.abdallah.tarea3dwesabdallah.repository.PlantaRepository;

@Service
public class ServiciosPlanta {

	@Autowired
	PlantaRepository plantarepo;
	
	
	@Autowired
	EjemplarRepository ejemplarrepo;
	
	public boolean validarPlanta(Planta p) {
			if(plantarepo.existeCodigo(p)) {
		return false;}
			
	return true;
			
			}
			
	
	public void insertarPlanta(Planta p) {
		plantarepo.saveAndFlush(p);
		
	}


	public Planta obtenerPorId(Long plantaId) {
		return null;
	}


	public void vertodasPlantas() {
		
	}


	public void modificarPlanta(Planta planta) {
		
	}


	public List<Planta> listarPlantasOrdenadas() {
		return null;
	}


	
	

}
