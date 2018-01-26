package br.com.app.fono.apifonoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.app.fono.apifonoapp.modelo.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	//TODO criar senha paciente
	public List<Paciente> findByEmailAndSenhaContaining(String email, String senha);
	

}
