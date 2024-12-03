package com.abdallah.tarea3dwesabdallah.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abdallah.tarea3dwesabdallah.modelo.Persona;
@Repository

public interface PersonaRepository extends JpaRepository<Persona,Long> {

}
