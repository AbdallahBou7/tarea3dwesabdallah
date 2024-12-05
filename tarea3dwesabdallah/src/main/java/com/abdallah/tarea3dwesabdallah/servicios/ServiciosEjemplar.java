package com.abdallah.tarea3dwesabdallah.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdallah.tarea3dwesabdallah.modelo.Ejemplar;
import com.abdallah.tarea3dwesabdallah.modelo.Planta;
import com.abdallah.tarea3dwesabdallah.repository.EjemplarRepository;

@Service
public class ServiciosEjemplar {
	
	@Autowired
	private EjemplarRepository ejemplarrepo;
	
	public Long ultimoIdEjemplarByPlanta(Planta p) {	
		
	if(p!=null)
		return ejemplarrepo.ultimoIdEjemplarByPlanta(p);
	else
		return 0L;
	
	}
	
	public void actualizar(Ejemplar e) {
		ejemplarrepo.saveAndFlush(e);
	}

	public void insertarEjemplar(Ejemplar ejemplar) {
		
	}
	

}
