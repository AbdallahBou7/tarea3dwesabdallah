package com.abdallah.tarea3dwesabdallah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.abdallah.tarea3dwesabdallah.modelo.*;
import com.abdallah.tarea3dwesabdallah.servicios.*;

public class Principal implements CommandLineRunner {

	@Autowired
	ServiciosPlanta servplant;
	
	@Autowired
	ServiciosEjemplar servejemplar;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		System.out.println("INI");
		
		Planta p = new Planta();
		servplant.validarPlanta(p);
		
		servplant.insertarPlanta(p);
		
		System.out.println("------------------------");
		
		
		System.out.println("FIN");
	}

}
