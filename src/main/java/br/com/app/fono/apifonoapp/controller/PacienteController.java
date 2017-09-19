package br.com.app.fono.apifonoapp.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.fono.apifonoapp.modelo.Paciente;
import br.com.app.fono.apifonoapp.service.PacienteService;


@RestController
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	// End points
	@RequestMapping(method = RequestMethod.GET, value = "/pacientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Paciente>> buscarTodosClientes() {
		Collection<Paciente> buscadosTodosPacientes = pacienteService.buscarTodos();
		return new ResponseEntity<>(buscadosTodosPacientes, HttpStatus.OK);
	}

}
