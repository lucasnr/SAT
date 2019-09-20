package br.gov.rn.saogoncalo.telecentro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"turma"}, callSuper=false)
public class Aluno extends Usuario {

	private Long id;
	private Turma turma;

	@Builder
	public Aluno(Long idUsuario, String matricula, String senha, Pessoa pessoa, Turma turma) {
		super(idUsuario, matricula, senha, pessoa);
		this.turma = turma;
	}
	
}
