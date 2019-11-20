package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.gov.rn.saogoncalo.telecentro.service.Visitable;
import br.gov.rn.saogoncalo.telecentro.service.Visitor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Delegate;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Visitable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INT")
	private Long id;

	@Getter
	@Setter
	private String matricula;

	@Getter
	@Setter
	protected String senha;

	@Getter
	@Delegate
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PESSOA_ID")
	protected Pessoa pessoa;
	
	@Getter
	@Setter
	@Transient
	private Perfil perfil;
	
	public Usuario() {
		this.pessoa = new Pessoa();
	}
	
	public Usuario(Perfil perfil) {
		this.pessoa = new Pessoa();
		this.perfil = perfil;
	}

	@Override
	public String accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
}
