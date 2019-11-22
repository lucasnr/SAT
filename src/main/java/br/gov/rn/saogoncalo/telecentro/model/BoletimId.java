package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoletimId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "ALUNO_ID", columnDefinition = "INT")
	private Long alunoId;
	@Column(name = "MODULO_ID", columnDefinition = "INT")
	private Long moduloId;
	
}