package com.consolecode.service;

import java.util.List;

import com.consolecode.model.Persona;

public interface IPersonaService {

	//Metodos del servicio para realizar el CRUD 
	List<Persona> listar();
	Persona registrar(Persona persona);
	Persona actualizar(Persona persona);
	void eliminar(Integer codigo);
	Persona ListarPorId(Integer codigo);
}
