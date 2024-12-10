package com.abdallah.tarea3dwesabdallah.vistas;

import java.sql.Date;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abdallah.tarea3dwesabdallah.modelo.Credenciales;
import com.abdallah.tarea3dwesabdallah.modelo.Ejemplar;
import com.abdallah.tarea3dwesabdallah.modelo.Mensaje;
import com.abdallah.tarea3dwesabdallah.modelo.Persona;
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

@Component
public class ViveroFachadaAdmin {

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

	public void mostrarMenuPrincipal() {
		int opcion = 0;
		
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("Seleccione una opcion:");
				System.out.println("1.  Gestionar Plantas.");
				System.out.println("2.  Gestionar Personas.");
				System.out.println("3.  Gestionar Mensajes.");
				System.out.println("4.  Gestionar Ejemplares.");
				System.out.println("5.  Salir");
				try {
					opcion = sc.nextInt();
					if (opcion < 1 || opcion > 5) {
						System.out.println("Opción incorrecta.");
						continue;
					}
					switch (opcion) {
					case 1:
						menuPlantas();
						break;
					case 2:
						menuPersonas();
						break;
					case 3:
						menuMensajes();
						break;
					case 4:
						menuEjemplares();
						break;

					case 5:
						System.out.println("Saliendo del menu de Administrador...");
						break;
					}
				} catch (InputMismatchException e) {

					System.out.println("Introduce un número correcto");
					sc.nextLine();
					opcion = 0;
				}

			} while (opcion != 5);
		}

	}

	private void menuEjemplares() {
		int opcion = 0;
		// Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de Ejemplares:---");
			System.out.println("1.  Ver ejemplares por tipo de planta.");
			System.out.println("2.  Ver mensajes de un ejemplar.");
			System.out.println("3.  Salir");
			try {
				// opcion = sc.nextInt();
				if (opcion < 1 || opcion > 3) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					// Ejemplar();
					break;
				case 2:
					// verEjemplaresPorTipoPlanta();
					break;
				case 3:
					// verMensajesPorEjemplar();
					break;

				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un numero.... Repita el proceso");
				// sc.nextLine();
				opcion = 0;

			}

		} while (opcion != 4);

	}


	private void menuPlantas() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de plantas:---");
			System.out.println("1.  Ver Plantas.");
			System.out.println("2.  Crear una Planta.");
			System.out.println("3.  Modificar Plantas.");
			System.out.println("4.  Salir");
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 4) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:
					servPlanta.vertodasPlantas();
					break;
				case 2:

					String codigo;
					String nombrecomun;
					String nombrecientifico;

					Planta pl = new Planta();
					do {
						sc = new Scanner(System.in);

						System.out.println("Dame el codigo de la nueva Planta");
						codigo = sc.nextLine();

						pl.setCodigo(codigo.trim().toUpperCase());

						System.out.println("Dame el nombre común de la nueva Planta ");
						nombrecomun = sc.nextLine();
						pl.setNombrecomun(nombrecomun);

						System.out.println("Dame el nombre científico de la nueva Planta ");
						nombrecientifico = sc.nextLine();
						pl.setNombrecientifico(nombrecientifico);

						if (!servPlanta.validarPlanta(pl)) {
							System.out.println("Planta invalida");
						}

					} while (!servPlanta.validarPlanta(pl));

					servPlanta.insertarPlanta(pl);
					break;
				case 3:
					menuModificarPlanta();
					break;

				}
			} catch (InputMismatchException e) {

				System.out.println("Introduce un número valido");
				sc.nextLine();
				opcion = 0;
			}

		} while (opcion != 4);

	}

	private void menuModificarPlanta() {

		int opcion = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("---Modificar Planta:---");
				System.out.println("1.  Modificar nombre comun.");
				System.out.println("2.  Modificar nombre cientifico.");
				System.out.println("3.  Salir");
				try {
					opcion = sc.nextInt();
					if (opcion < 1 || opcion > 3) {
						System.out.println("Opción incorrecta.");
						continue;
					}
					switch (opcion) {
					case 1:
						System.out.println("Introduce el codigo de la planta a modificar");
						String codigo = sc.next();
						Optional<Planta> pl = plantarepo.findById(codigo);
						if (!pl.isEmpty()) {
							sc.nextLine();
							System.out.println("Introduce el nuevo nombre comun");
							String nuevo = sc.nextLine();
							pl.get().setNombrecomun(nuevo);
							servPlanta.modificarPlanta(pl.get());
						} else {
							System.out.println("El codigo no existe");
						}
						break;
					case 2:
						System.out.println("Introduce el codigo de la planta a modificar");
						codigo = sc.next();
						Optional<Planta> p2 = plantarepo.findById(codigo);
						if (!p2.isEmpty()) {
							sc.nextLine();
							System.out.println("Introduce el nuevo nombre cientifico");
							String nuevo = sc.nextLine();
							p2.get().setNombrecientifico(nuevo);
							servPlanta.modificarPlanta(p2.get());
						} else {
							System.out.println("El codigo no existe");
						}

						break;

					case 3:
						break;
					}
				} catch (InputMismatchException e) {
					System.out.println("Introduce un número.... Repita el proceso");
					sc.nextLine();
					opcion = 0;
				}
			} while (opcion != 3);
		}

	}

	public void menuMensajes() {
		int opcion = 0;
		try (Scanner sc = new Scanner(System.in)) {
			do {
				System.out.println("---Gestion de Mensajes:---");
				System.out.println("1.  Crear Mensaje");
				System.out.println("2.  Ver todos los Mensajes (SIN FILTRAR).");
				System.out.println("3.  Ver Mensajes (FILTRADO).");
				System.out.println("4.  Salir");
				try {
					opcion = sc.nextInt();
					if (opcion < 1 || opcion > 4) {
						System.out.println("Opción incorrecta.");
						continue;
					}
					switch (opcion) {
					case 1:
						crearMensaje();
						break;
					case 2:
						servMensaje.verTodosMensajes();
						break;
					case 3:
						// menuFiltrarMensaje();

						break;

					}
				} catch (InputMismatchException e) {
					System.out.println("Introduce un numero.... Repita el proceso");
					sc.nextLine();
					opcion = 0;

				}

			} while (opcion != 4);
		}

	}

	private void crearMensaje() {
		Mensaje m = new Mensaje();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Introduce el nombre del ejemplar");
			String nombre = sc.next();

			List<Ejemplar> ejemplares = ejemplarrepo.findAll();
			Ejemplar ej = new Ejemplar();
			Boolean existe = false;
			for (Ejemplar e : ejemplares) {
				if (e.getNombre().equals(nombre)) {
					ej = e;
					existe = true;
				}
			}
			if (existe == false) {
				System.out.println("No existe el ejemplar");
			} else {
				System.out.println("Introduce el mensaje: ");
				String mensaje = sc.next();

				Optional<Persona> personas = servPersona.buscarPorId(Long.valueOf(1));
				m.setPersona(personas.get());
				m.setEjemplar(ej);

				LocalDate fechahora = LocalDate.now();
				Date date = Date.valueOf(fechahora);
				m.setFechahora(date);
				m.setMensaje(mensaje);

				servMensaje.insertar(m);
			}
		}
	}


	private void menuPersonas() {

		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("---Gestion de personas:---");
			System.out.println("1.  Ver Personas.");
			System.out.println("2.  Añadir persona.");
			System.out.println("3.  Salir");
			try {
				opcion = sc.nextInt();
				if (opcion < 1 || opcion > 3) {
					System.out.println("Opción incorrecta.");
					continue;
				}
				switch (opcion) {
				case 1:

					servPersona.obtenerTodas();

					break;
				case 2:
					boolean personaValida = false;
					Persona p = new Persona();
					sc = new Scanner(System.in);

					System.out.println("Dame el nombre de la nueva Persona");
					String nombre = sc.nextLine();

					System.out.println("Dame el email de la nueva Persona");
					String email = sc.nextLine();

					System.out.println("Introduce el nombre de usuario");
					String usuario = sc.nextLine();

					System.out.println("Introduce el password");
					String password = sc.nextLine();

					if (servCredencial.existeCredencial(usuario)) { 
						System.out.println("Ya existe el  usuario en credenciales: " + usuario);
					} else {
						personaValida = servPersona.validarPersona(email, nombre);
						if (!personaValida) {
							System.out.println(" Persona datos no validos... Repita el proceso");
						} else {
							Credenciales c = new Credenciales();
							c.setUsuario(usuario);
							c.setPassword(password);

							p.setNombre(nombre);
							p.setEmail(email);
						//	p.setCredenciales(c);
							servPersona.guardarPersona(p);
						}

					}

					break;
				case 3:

					break;
				}
			} catch (InputMismatchException e) {

				System.out.println("Introduce un número.... Repita el proceso");
				sc.nextLine();
				opcion = 0;
			}

		} while (opcion != 3);
	}

}
