package com.consolecode.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.consolecode.model.Persona;
import com.consolecode.service.IPersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	private IPersonaService service;
	
	@GetMapping
	public ResponseEntity<List<Persona>> listar(){
		List<Persona> obj = service.listar();
		return new ResponseEntity<List<Persona>>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	//Con RequestBody convierte el objeto pais en un JSON
	public ResponseEntity<Void> registrar(@RequestBody Persona persona){
		Persona obj = service.registrar(persona);
		// Cogemos nuestro localhost = localhost:8080/persona junto con el id dinamico
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();
		return  ResponseEntity.created(uri).build();
	}
	
	@PutMapping
	public ResponseEntity<Persona> actualizar(@RequestBody Persona persona){
		Persona obj = service.registrar(persona);
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
	
	//Le pasamos un id a la ruta y elimina dicha entrada con ese id
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Persona obj = service.ListarPorId(id);
		if(obj == null) {
			throw new Exception("No se encontró ID");
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id)throws Exception{
		Persona obj = service.ListarPorId(id);
		if(obj == null) {
			throw new Exception("No se encontró ID");
		}
		return new ResponseEntity<Persona>(obj, HttpStatus.OK);
	}
}
