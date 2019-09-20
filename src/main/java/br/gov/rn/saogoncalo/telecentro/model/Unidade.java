package br.gov.rn.saogoncalo.telecentro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Unidade {

	private Long id;
	private String nome;
	private Integer quantidadeEquipamentos;
	private Endereco endereco;

}
