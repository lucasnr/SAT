package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.rn.saogoncalo.telecentro.service.Visitable;
import br.gov.rn.saogoncalo.telecentro.service.Visitor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(exclude = {"turmas"}, callSuper = false)
@ToString(exclude = {"turmas"})
@Entity
@Table(name = "INSTRUTOR")
@PrimaryKeyJoinColumn(name = "USUARIO_ID")
public class Instrutor extends Usuario implements Visitable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instrutor")
	private List<Turma> turmas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIDADE_ID")
	private Unidade unidade;

	public Instrutor() {
		super(Perfil.INSTRUTOR);
	}
	
	@Builder
	public Instrutor(Long idUsuario, String matricula, String senha, Pessoa pessoa) {
		super(idUsuario, matricula, senha, pessoa, Perfil.INSTRUTOR);
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
