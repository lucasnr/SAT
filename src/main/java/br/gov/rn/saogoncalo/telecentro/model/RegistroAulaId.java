package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistroAulaId implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ALUNO_ID", columnDefinition = "INT")
	private Long alunoId;
	@Column(name = "AULA_ID", columnDefinition = "INT")
	private Long aulaId;
	
}