package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT")
	private Long id;
	private String nome;
	@Column(columnDefinition = "CHAR(14)")
	private String cpf;
	@Column(columnDefinition = "CHAR(11)")
	private String rg;
	@Column(name = "DATA_NASCIMENTO")
	private LocalDate dataNascimento;
	@Column(name = "DATA_CADASTRO")
	private LocalDateTime dataCadastro;
	@Enumerated(EnumType.STRING)
	@Column(columnDefinition = "ENUM('MASCULINO','FEMININO', 'OUTRO')")
	private Sexo sexo;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Contato contato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENDERECO_ID")
	private Endereco endereco;
	
	public Pessoa() {
		this.contato = new Contato();
		this.endereco = new Endereco();
	}

	public boolean isMulher() {
		return this.sexo == Sexo.FEMININO;
	}
	
	@PrePersist
	public void prePersist() {
		this.dataCadastro = LocalDateTime.now();
	}
}
