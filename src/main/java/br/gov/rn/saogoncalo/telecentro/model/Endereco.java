package br.gov.rn.saogoncalo.telecentro.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {

	private Long id;
	private String cep;
	private String bairro;
	private String logradouro;
	private String numero;

}
