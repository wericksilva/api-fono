package br.com.app.fono.apifonoapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.app.fono.apifonoapp.modelo.Consulta;
import br.com.app.fono.apifonoapp.modelo.Paciente;
import br.com.app.fono.apifonoapp.repository.ConsultaRepository;
import br.com.app.fono.apifonoapp.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;
	
	@Autowired
	ConsultaRepository consultaRepository;
	
	public List<Paciente> buscarTodos() {
		
		return pacienteRepository.findAll();
	}

	public Paciente salvar(Paciente paciente){
		Paciente pacienteIncluido = pacienteRepository.save(paciente);
		
		List<Consulta> listaConsulta = new ArrayList<Consulta>();
		
		for (Consulta cosulta : paciente.getConsulta()) {
			cosulta.setPaciente(paciente);
			listaConsulta.add(consultaRepository.save(cosulta));
		}
		pacienteIncluido.getConsulta().clear();
		pacienteIncluido.setConsulta(listaConsulta);
		return pacienteIncluido;
	}


	public Paciente buscarPoId(Long id) {
		return pacienteRepository.findOne(id);
	}
	
	public void excluir(Paciente paciente){
		pacienteRepository.delete(paciente);
	}

}
