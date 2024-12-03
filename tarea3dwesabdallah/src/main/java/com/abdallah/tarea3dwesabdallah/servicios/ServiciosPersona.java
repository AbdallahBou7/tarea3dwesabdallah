package com.abdallah.tarea3dwesabdallah.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdallah.tarea3dwesabdallah.modelo.Persona;
import com.abdallah.tarea3dwesabdallah.repository.PersonaRepository;

@Service
public class ServiciosPersona {
	
	  @Autowired
	    private PersonaRepository personarep;

	    public void guardarPersona(Persona persona) {
	        personarep.save(persona);
	    }

	    public List<Persona> obtenerTodas() {
	        return personarep.findAll();
	    }

}
