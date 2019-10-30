package br.gov.rn.saogoncalo.telecentro.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"turmas"}, callSuper = false)
@ToString(exclude = {"turmas"})
@Entity
@Table(name = "INSTRUTOR")
@PrimaryKeyJoinColumn(name = "USUARIO_ID")
public class Instrutor extends Usuario {

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instrutor")
	private List<Turma> turmas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIDADE_ID")
	private Unidade unidade;

	@Builder
	public Instrutor(Long idUsuario, String matricula, String senha, Pessoa pessoa) {
		super(idUsuario, matricula, senha, pessoa);
	}
}
