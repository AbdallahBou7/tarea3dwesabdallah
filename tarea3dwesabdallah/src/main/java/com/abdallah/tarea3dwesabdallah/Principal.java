package com.abdallah.tarea3dwesabdallah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.abdallah.tarea3dwesabdallah.modelo.Planta;
import com.abdallah.tarea3dwesabdallah.servicios.ServiciosPlanta;

public class Principal implements CommandLineRunner {

	@Autowired
	
	ServiciosPlanta servplant;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("INI");
		
		Planta p = new Planta();
		servplant.validarPlanta(p);
		
		System.out.println("------------------------");
		
		
		System.out.println("FIN");
	}

}
