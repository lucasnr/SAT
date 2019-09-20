package br.gov.rn.saogoncalo.telecentro.model;

public class Modulo {

	private final String titulo;
	private final String descricao;

	public Modulo(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

}
