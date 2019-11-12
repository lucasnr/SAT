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
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", columnDefinition = "INT")
	private Long id;

	@Getter
	@Setter
	private String matricula;

	@Getter
	@Setter
	private String senha;

	@Getter
	@Delegate
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PESSOA_ID")
	private Pessoa pessoa;
	
	public Usuario() {
		this.pessoa = new Pessoa();
	}
	
}
