package br.com.app.fono.apifonoapp.enums;

public enum EnumPlano {

	AMIL("Amil"),
	UNIMEDE("Unimede"),
	SUL_AMERICA("Sul América"),
	BRADESCO("Bradesco");
	
	public String nome;

	private EnumPlano(String nome) {
		this.nome = nome;
	}
}
