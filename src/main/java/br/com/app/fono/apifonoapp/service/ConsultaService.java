package br.com.app.fono.apifonoapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.app.fono.apifonoapp.modelo.Consulta;
import br.com.app.fono.apifonoapp.repository.ConsultaRepository;

public class ConsultaService {

	@Autowired
	ConsultaRepository consultaRepository;
	
	
	public Consulta salvar(Consulta consulta){
		return consultaRepository.save(consulta);
	}




}
