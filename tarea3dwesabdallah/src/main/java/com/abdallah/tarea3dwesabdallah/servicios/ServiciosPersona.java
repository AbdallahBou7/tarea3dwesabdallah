package com.abdallah.tarea3dwesabdallah.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdallah.tarea3dwesabdallah.modelo.Persona;
import com.abdallah.tarea3dwesabdallah.repository.PersonaRepository;

@Service
public class ServiciosPersona {
	
	  @Autowired
	    private PersonaRepository personarep;
	  
	  public Persona autenticar(Long id, String nombre) {
	        return personarep.findByIdAndNombre(id, nombre);
	    }

	    public void guardarPersona(Persona persona) {
	        personarep.save(persona);
	    }

	    public List<Persona> obtenerTodas() {
	        return personarep.findAll();
	    }

		public Optional<Persona> buscarPorId(Long valueOf) {
			return null;
		}

		public boolean validarPersona(String email, String nombre) {
			return false;
		}

		public Persona autenticarUsuario(String usuario, String contrasena) {
			return null;
		}

		public void registrarUsuario(String nombre, String correo, String usuario, String contrasena) {
			
		}

		

	

		

		

}
