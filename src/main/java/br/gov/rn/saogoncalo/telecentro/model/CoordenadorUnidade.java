package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.rn.saogoncalo.telecentro.service.Visitable;
import br.gov.rn.saogoncalo.telecentro.service.Visitor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "COORDENADOR_UNIDADE")
@PrimaryKeyJoinColumn(name = "COORDENADOR_ID")
public class CoordenadorUnidade extends Coordenador implements Visitable {

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIDADE_ID")
	private Unidade unidade;

	@Builder
	public CoordenadorUnidade(Pessoa pessoa, Unidade unidade, String senha) {
		this.unidade = unidade;
		super.pessoa = pessoa;
		super.senha = senha;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
