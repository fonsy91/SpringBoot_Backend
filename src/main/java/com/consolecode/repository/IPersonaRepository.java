package com.consolecode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.consolecode.model.Persona;

// Esta clase al extends de JpaRepository es como si tuviera una etiqueta @Repository
public interface IPersonaRepository extends JpaRepository<Persona, Integer>{

}
