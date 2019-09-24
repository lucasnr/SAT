package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"turma"}, callSuper=false)
@Entity
@Table(name = "ALUNO")
@PrimaryKeyJoinColumn(name = "USUARIO_ID")
public class Aluno extends Usuario {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TURMA_ID")
	private Turma turma;

	@Builder
	public Aluno(Long idUsuario, String matricula, String senha, Pessoa pessoa, Turma turma) {
		super(idUsuario, matricula, senha, pessoa);
		this.turma = turma;
	}
	
}
