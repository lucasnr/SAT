package br.gov.rn.saogoncalo.telecentro.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {
	
	private Long id;
	private String nome;
	private String cpf;
	private String rg;
	private LocalDate dataNascimento;
	private LocalDateTime dataCadastro;
	private Sexo sexo;
	private Contato contato;
	private Endereco endereco;
	
}
