package br.gov.rn.saogoncalo.telecentro.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude= {"turmas"}, callSuper=false)
@ToString(exclude= {"turmas"})
public class Instrutor extends Usuario {

	private List<Turma> turmas;

	@Builder
	public Instrutor(Long idUsuario, String matricula, String senha, Pessoa pessoa) {
		super(idUsuario, matricula, senha, pessoa);
	}
}
