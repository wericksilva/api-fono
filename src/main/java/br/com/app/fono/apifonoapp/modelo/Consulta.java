package br.com.app.fono.apifonoapp.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.app.fono.apifonoapp.enums.EnumPlano;

@Entity
public class Consulta {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Boolean plano ;
	
	@Enumerated(EnumType.STRING)
	private EnumPlano planoDeSaude;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private String queixa;
	
	private String diagnostico;
	
	private String terapia;
	
	private String encaminhamentos;
	

	@JsonBackReference
	@ManyToOne
	private Paciente paciente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPlano() {
		return plano;
	}

	public void setPlano(Boolean plano) {
		this.plano = plano;
	}

	public EnumPlano getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(EnumPlano planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getQueixa() {
		return queixa;
	}

	public void setQueixa(String queixa) {
		this.queixa = queixa;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getTerapia() {
		return terapia;
	}

	public void setTerapia(String terapia) {
		this.terapia = terapia;
	}

	public String getEncaminhamentos() {
		return encaminhamentos;
	}

	public void setEncaminhamentos(String encaminhamentos) {
		this.encaminhamentos = encaminhamentos;
	}

	/**
	 * @return the paciente
	 */
	public Paciente getPaciente() {
		return paciente;
	}

	/**
	 * @param paciente the paciente to set
	 */
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}

