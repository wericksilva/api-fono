package br.com.app.fono.apifonoapp.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.fono.apifonoapp.modelo.Paciente;
import br.com.app.fono.apifonoapp.service.PacienteService;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	// End points
	@PostMapping
	public Paciente adicionar(@Valid @RequestBody Paciente paciente) {
		return pacienteService.salvar(paciente);
	}
	
	@GetMapping
	public List<Paciente> listar() {
		return pacienteService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Paciente> buscar(@PathVariable Long id) {
		Paciente paciente = pacienteService.buscarPoId(id);
		
		if (paciente == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(paciente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Paciente> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Paciente paciente) {
		Paciente existente = pacienteService.buscarPoId(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(paciente, existente, "id");
		
		existente = pacienteService.salvar(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Paciente paciente = pacienteService.buscarPoId(id);
		
		if (paciente == null) {
			return ResponseEntity.notFound().build();
		}
		
		pacienteService.excluir(paciente);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
