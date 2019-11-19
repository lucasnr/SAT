package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.gov.rn.saogoncalo.telecentro.service.Visitable;
import br.gov.rn.saogoncalo.telecentro.service.Visitor;

@Entity
@Table(name = "COORDENADOR_GERAL")
@PrimaryKeyJoinColumn(name = "COORDENADOR_ID")
public class CoordenadorGeral extends Coordenador implements Visitable {

	public CoordenadorGeral() {
		super(Perfil.COORDENADOR_GERAL);
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
}
