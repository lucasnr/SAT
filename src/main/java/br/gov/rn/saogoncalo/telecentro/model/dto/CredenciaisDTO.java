package br.gov.rn.saogoncalo.telecentro.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredenciaisDTO {

	private String matricula;
	private String senha;

}
