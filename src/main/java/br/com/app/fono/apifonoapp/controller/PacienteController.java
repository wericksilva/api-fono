package br.com.app.fono.apifonoapp.controller;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.fono.apifonoapp.enums.EnumSexo;
import br.com.app.fono.apifonoapp.modelo.Paciente;
import br.com.app.fono.apifonoapp.service.PacienteService;


@RestController
@CrossOrigin("${origem-permitida}")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	// End points
	@RequestMapping(method = RequestMethod.GET, value = "/pacientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Paciente>> buscarPacientes() {
		Collection<Paciente> buscadosTodosPacientes = pacienteService.buscarTodos();
		return new ResponseEntity<>(buscadosTodosPacientes, HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/pacientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente> cadastrarPaciente(@RequestBody Paciente paciente) {
		paciente.setSexo(EnumSexo.M);
		Paciente pacienteCadastrado = pacienteService.salvar(paciente);
		return new ResponseEntity<Paciente>(pacienteCadastrado, HttpStatus.CREATED);

	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/pacientes/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Paciente>  buscarPacientePorEmaileSenha(@RequestBody Paciente paciente) {
		Paciente pacienteCadastrado = pacienteService.buscarPorEmaileSenha(paciente);
		return new ResponseEntity<>(pacienteCadastrado, HttpStatus.OK);
	}
	
	
}
