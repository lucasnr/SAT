package br.gov.rn.saogoncalo.telecentro.model;

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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PESSOA")
public class Pessoa {

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
	@Column(columnDefinition = "ENUM('MASCULINO','FEMININO')")
	private Sexo sexo;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Contato contato;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENDERECO_ID")
	private Endereco endereco;

}
