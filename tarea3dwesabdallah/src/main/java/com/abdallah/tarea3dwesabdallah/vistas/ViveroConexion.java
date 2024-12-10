package com.abdallah.tarea3dwesabdallah.vistas;

	import com.abdallah.tarea3dwesabdallah.servicios.ServiciosPersona;
	import com.abdallah.tarea3dwesabdallah.modelo.Persona;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Component;

	import java.util.Scanner;

	@Component
	public class ViveroConexion {

	    @Autowired
	    private ServiciosPersona servpersona;

	    
	    private final Scanner scanner = new Scanner(System.in);
	    
	    
	    
	    public void mostrarMenuLogin() {
	        boolean continuar = true;
	        while (continuar) {
	            System.out.println("\n--- Menú de Login ---");
	            System.out.println("1. Iniciar Sesión");
	            System.out.println("2. Registrarse");
	            System.out.println("3. Salir");
	            System.out.print("Seleccione una opción: ");

	            int opcion = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcion) {
	                case 1 -> iniciarSesion();
	                case 2 -> registrarUsuario();
	                case 3 -> continuar = false;
	                default -> System.out.println("Opción no válida.");
	            }
	        }
	    }

	    private void iniciarSesion() {
	        System.out.print("Ingrese el nombre de usuario: ");
	        String usuario = scanner.nextLine();
	        System.out.print("Ingrese la contraseña: ");
	        String contrasena = scanner.nextLine();

	        Persona persona = servpersona.autenticarUsuario(usuario, contrasena);
	        if (persona != null) {
	            System.out.println("Bienvenido, " + persona.getNombre()+ "!");
	        } else {
	            System.out.println("Credenciales incorrectas.");
	        }
	    }

	    private void registrarUsuario() {
	        System.out.print("Ingrese su nombre: ");
	        String nombre = scanner.nextLine();
	        System.out.print("Ingrese su correo electrónico: ");
	        String correo = scanner.nextLine();
	        System.out.print("Ingrese un nombre de usuario: ");
	        String usuario = scanner.nextLine();
	        System.out.print("Ingrese una contraseña: ");
	        String contrasena = scanner.nextLine();

	        servpersona.registrarUsuario(nombre, correo, usuario, contrasena);
	    }

		
	}


