package com.abdallah.tarea3dwesabdallah;

import com.abdallah.tarea3dwesabdallah.modelo.Persona;

// import com.abdallah.tarea3dwesabdallah.vistas.ViveroFachadaPersonal;
// import com.abdallah.tarea3dwesabdallah.modelo.Persona;

import com.abdallah.tarea3dwesabdallah.servicios.ServiciosPersona;
// import com.abdallah.tarea3dwesabdallah.vistas.ViveroConexion;
import com.abdallah.tarea3dwesabdallah.vistas.ViveroFachadaAdmin;
import com.abdallah.tarea3dwesabdallah.vistas.ViveroFachadaInvitado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Principal implements CommandLineRunner {

	@Autowired
    private ServiciosPersona servpersona;
	
	@Autowired
    private ViveroFachadaAdmin FachadaAdmin;
	
	@Autowired
    private ViveroFachadaInvitado fachadaInvitado;

   // @Autowired
   // private ViveroFachadaPersonal fachadaPersonal;

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(String... args) {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Sistema del Vivero ---");
            System.out.println("1. Iniciar como Administrador");
            System.out.println("2. Iniciar como Personal");
            System.out.println("3. Entrar como Invitado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1 -> iniciarSesionComoAdmin();
                // case 2 -> iniciarSesionComoPersonal();
                case 3 -> entrarComoInvitado();
                case 4 -> {
                    continuar = false;
                    System.out.println("Saliendo del sistema...");
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private void iniciarSesionComoAdmin() {
        System.out.println("\n--- Login de Administrador ---");
        System.out.print("Ingrese su usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Persona autenticado = servpersona.autenticarUsuario(usuario, contrasena);
        if (autenticado != null) {
            System.out.println("Bienvenido Administrador.");
            FachadaAdmin.mostrarMenuPrincipal();
        } else {
            System.out.println("Credenciales incorrectas. Intente de nuevo.");
        }
    }

   // private void iniciarSesionComoPersonal() {
      //  System.out.println("\n--- Login de Personal ---");
     //   System.out.print("Ingrese su usuario: ");
     //   String usuario = scanner.nextLine();
     //   System.out.print("Ingrese su contraseña: ");
    //    String contrasena = scanner.nextLine();

    //    boolean autenticado = fachadaPersonal.autenticar(usuario, contrasena);
     //   if (autenticado) {
       //     System.out.println("Acceso concedido como Personal.");
           // fachadaPersonal.mostrarMenuInvitado();
      //  } else {
     //       System.out.println("Credenciales incorrectas. Intente de nuevo.");
     //   }
  //  }
    
    
// }
    
    private void entrarComoInvitado() {
        System.out.println("\n--- Acceso como Invitado ---");
        fachadaInvitado.MostrarMenuInvitado();
    }
    
    
}

