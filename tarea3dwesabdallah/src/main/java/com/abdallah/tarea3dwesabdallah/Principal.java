package com.abdallah.tarea3dwesabdallah;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.abdallah.tarea3dwesabdallah.modelo.*;
import com.abdallah.tarea3dwesabdallah.servicios.*;

import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

    @Autowired
    private ServiciosPlanta servplant;

    @Autowired
    private ServiciosEjemplar servejemplar;

    @Autowired
    private ServiciosPersona servicioPersona;

    @Autowired
    private ServiciosMensaje servicioMensaje;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-------- INI ---------");
        boolean continuar = true;

        Scanner scanner = new Scanner(System.in);

        while (continuar) {
            mostrarMenu();
            int opcion = obtenerOpcion(scanner);

            switch (opcion) {
                case 1 -> verPlantas();
                case 2 -> registrarPersona(scanner);
                case 3 -> registrarPlanta(scanner);
                case 4 -> registrarEjemplar(scanner);
                case 5 -> verMensajes();
                case 6 -> continuar = false;
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        System.out.println("-------- FIN ---------");
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Ver Plantas");
        System.out.println("2. Registrar Persona");
        System.out.println("3. Registrar Planta");
        System.out.println("4. Registrar Ejemplar");
        System.out.println("5. Ver Mensajes");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private int obtenerOpcion(Scanner scanner) {
        int opcion;
        try {
            opcion = scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine(); 
            opcion = -1; 
        }
        return opcion;
    }

    private void verPlantas() {
        System.out.println("--- Lista de Plantas ---");
       
    }

    private void registrarPersona(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el correo: ");
        String email = scanner.nextLine();

        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setEmail(email);

        servicioPersona.guardarPersona(persona);
        System.out.println("Persona registrada exitosamente: " + persona);
    }

    private void registrarPlanta(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Ingrese el nombre de la planta: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nombre cientifico de planta: ");
        String nombrecientifico = scanner.nextLine();

        Planta planta = new Planta();
		planta.setNombrecomun(nombre);
        planta.setNombrecientifico(nombrecientifico);

        if (servplant.validarPlanta(planta)) {
            servplant.insertarPlanta(planta);
            System.out.println("Planta registrada: " + planta);
        } else {
            System.out.println("La planta no pasó la validación.");
        }
    }

    private void registrarEjemplar(Scanner scanner) {
        scanner.nextLine(); 
        System.out.print("Ingrese el código del ejemplar: ");
        Long Id = scanner.nextLong();
        System.out.print("Ingrese el ID de la planta: ");
        Long plantaId = scanner.nextLong();

        Planta planta = servplant.obtenerPorId(plantaId);
        if (planta == null) {
            System.out.println("La planta con ID " + plantaId + " no existe.");
            return;
        }

        Ejemplar ejemplar = new Ejemplar();
        ejemplar.setId(Id);
        ejemplar.setPlanta(planta);

        servejemplar.insertarEjemplar(ejemplar);
        System.out.println("Ejemplar registrado exitosamente: " + ejemplar);
    }

    private void verMensajes() {
        System.out.println("--- Lista de Mensajes ---");
    }
}

