package br.gov.rn.saogoncalo.telecentro.model.dto;

public class CredenciaisDTO {

	private String matricula;
	private String senha;

	public CredenciaisDTO(String matricula, String senha) {
		this.matricula = matricula;
		this.senha = senha;
	}
	
	public CredenciaisDTO() {
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
