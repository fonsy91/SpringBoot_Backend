package com.consolecode.service;

import java.util.List;

import com.consolecode.model.Pais;

public interface IPaisService {

	//Metodos del servicio para realizar el CRUD 
	List<Pais> listar();
	Pais registrar(Pais persona);
	Pais actualizar(Pais persona);
	void eliminar(Integer codigo);
	Pais ListarPorId(Integer codigo);
}
