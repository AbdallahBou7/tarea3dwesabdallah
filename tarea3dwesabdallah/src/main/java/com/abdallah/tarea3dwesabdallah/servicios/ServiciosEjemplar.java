package com.abdallah.tarea3dwesabdallah.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdallah.tarea3dwesabdallah.modelo.Ejemplar;
import com.abdallah.tarea3dwesabdallah.repository.EjemplarRepository;

@Service
public class ServiciosEjemplar {
	
	@Autowired
	private EjemplarRepository ejemplarrepo;
	
	
	
	public void actualizar(Ejemplar e) {
		ejemplarrepo.saveAndFlush(e);
	}

	public void insertarEjemplar(Ejemplar ejemplar) {
		
	}

	public List<Ejemplar> listaejemplaresPorTipoPlanta(String tipo) {
		return null;
	}
	

}
