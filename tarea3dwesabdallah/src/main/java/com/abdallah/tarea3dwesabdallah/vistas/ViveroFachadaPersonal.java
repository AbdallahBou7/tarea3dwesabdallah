package com.abdallah.tarea3dwesabdallah.vistas;

import com.abdallah.tarea3dwesabdallah.modelo.Planta;
import com.abdallah.tarea3dwesabdallah.repository.CredencialesRepository;
import com.abdallah.tarea3dwesabdallah.repository.EjemplarRepository;
import com.abdallah.tarea3dwesabdallah.repository.PersonaRepository;
import com.abdallah.tarea3dwesabdallah.repository.PlantaRepository;
import com.abdallah.tarea3dwesabdallah.servicios.ServiciosCredenciales;
import com.abdallah.tarea3dwesabdallah.servicios.ServiciosEjemplar;
import com.abdallah.tarea3dwesabdallah.servicios.ServiciosMensaje;
import com.abdallah.tarea3dwesabdallah.servicios.ServiciosPersona;
import com.abdallah.tarea3dwesabdallah.servicios.ServiciosPlanta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ViveroFachadaPersonal {

	@Autowired
	ServiciosPlanta servPlanta;

	@Autowired
	ServiciosPersona servPersona;

	@Autowired
	ServiciosCredenciales servCredencial;

	@Autowired
	ServiciosEjemplar servEjemplar;

	@Autowired
	ServiciosMensaje servMensaje;

	@Autowired
	PlantaRepository plantarepo;

	@Autowired
	PersonaRepository personarepo;

	@Autowired
	CredencialesRepository credencialrepo;

	@Autowired
	EjemplarRepository ejemplarrepo;
	
    

    private final Scanner scanner = new Scanner(System.in);

    public void mostrarMenuPersonal() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú Principal del Personal de Vivero ---");
            System.out.println("1. Gestión de Ejemplares");
            System.out.println("2. Gestión de Plantas");
            System.out.println("3. Gestión de Mensajes");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
            //        case 1 -> menuEjemplares();
                case 2 -> menuPlantas();
                //       case 3 -> menuMensajes();
                case 4 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

 //    private void menuEjemplares() {
    //     boolean continuar = true;
    //     while (continuar) {
    //        System.out.println("\n--- Menú de Ejemplares ---");
            //         System.out.println("1. Registrar Ejemplar");
    //        System.out.println("2. Ver Ejemplares");
    //       System.out.println("3. Filtrar Ejemplares por Tipo");
            //       System.out.println("4. Volver");
    //       System.out.print("Seleccione una opción: ");

    //        int opcion = scanner.nextInt();
    //         scanner.nextLine(); 

    //        switch (opcion) {
    //             case 1 -> registrarEjemplar();
                //            case 2 -> verEjemplares();
    //           case 3 -> filtrarEjemplaresPorTipo();
                //            case 4 -> continuar = false;
    //            default -> System.out.println("Opción no válida.");
    //        }
    //     }
    //   }

    private void menuPlantas() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Menú de Plantas ---");
            System.out.println("1. Ver Plantas");
            System.out.println("2. Volver");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> verPlantas();
                case 2 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

  //  private void menuMensajes() {
       // boolean continuar = true;
     //   while (continuar) {
         //   System.out.println("\n--- Menú de Mensajes ---");
           // System.out.println("1. Enviar Mensaje");
           // System.out.println("2. Ver Mensajes de Seguimiento");
           // System.out.println("3. Volver");
           // System.out.print("Seleccione una opción: ");

             // int opcion = scanner.nextInt();
            // scanner.nextLine(); 

            // switch (opcion) {
              //  case 1 ->;
                // case 2 -> ;
               // case 3 -> continuar = false;
               // default -> System.out.println("Opción no válida.");
           // }
       // }
    // }




    private void verPlantas() {
        List<Planta> plantas = plantarepo.listarPlantasOrdenadas();
        System.out.println("--- Lista de Plantas ---");
        for (int i = 0; i < plantas.size(); i++) {
            Planta planta = plantas.get(i);
            System.out.printf("ID: %d | Nombre: %s | Tipo: %s%n", planta.getId(), planta.getNombrecomun());
        }
    }

    

 
}
