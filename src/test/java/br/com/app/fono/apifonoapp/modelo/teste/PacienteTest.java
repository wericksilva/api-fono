package br.com.app.fono.apifonoapp.modelo.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.app.fono.apifonoapp.modelo.Paciente;


public class PacienteTest {
	
	private Paciente paciente = new Paciente();
	
	@Before
	public void init() {
		
	}
	
	@Test
	public void testPaciente() {
		
		Assert.assertNotNull(paciente);
		paciente.setId(1L);
		
		Assert.assertEquals(new Long(1), paciente.getId());
	}
	

}
