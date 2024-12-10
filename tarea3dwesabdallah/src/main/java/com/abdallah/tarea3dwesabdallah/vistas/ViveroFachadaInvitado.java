package com.abdallah.tarea3dwesabdallah.vistas;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abdallah.tarea3dwesabdallah.modelo.Planta;
import com.abdallah.tarea3dwesabdallah.servicios.ServiciosPlanta;


@Component
public class ViveroFachadaInvitado {
	
	
	@Autowired
	ServiciosPlanta servPlanta;

		public void MostrarMenuInvitado(){
			int opcion = 0;
			
			try (Scanner sc = new Scanner(System.in)) {
				do {
					System.out.println("Menu De Invitado :");
					System.out.println("1.  Ver Plantas.");
					System.out.println("2.  Login.");
					System.out.println("3.  Salir.");
					
					try {
						opcion = sc.nextInt();
						if (opcion < 1 || opcion > 3) {
							System.out.println("Opción incorrecta.");
							continue;
						}
						switch (opcion) {
						case 1:
						verPlantas();
							break;
						case 2:
						//	Login();
							break;

						case 3:
							System.out.println("Saliendo del menu...");
							break;
						}
					} catch (InputMismatchException e) {

						System.out.println("Introduce un número correcto");
						sc.nextLine();
						opcion = 0;
					}

				} while (opcion != 3);
			}
		}
		
		private void verPlantas() {
	        List<Planta> plantas = servPlanta.listarPlantasOrdenadas();
	        System.out.println("--- Lista de Plantas Disponibles ---");
	        for (Planta planta : plantas) {
	            System.out.printf("Codigo: %s | NombreComun: %s | NombreCientifico: %s%n ", planta.getCodigo(), planta.getNombrecomun(), planta.getNombrecientifico());
	        }
	    }
		
		
		private void login() {
			
			
			
		}
		
		
		
		
		
		
		
		
}
