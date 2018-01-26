package br.com.app.fono.apifonoapp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.fono.apifonoapp.modelo.Paciente;
import br.com.app.fono.apifonoapp.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	public Collection<Paciente> buscarTodos() {
		return pacienteRepository.findAll();
	}

	public Paciente salvar(Paciente paciente){
		return pacienteRepository.save(paciente);
	}
	
	public Paciente buscarPorEmaileSenha(Paciente paciente){
		return pacienteRepository.findByEmailAndSenhaContaining(paciente.getEmail(), paciente.getSenha()).get(0);
	}
}
