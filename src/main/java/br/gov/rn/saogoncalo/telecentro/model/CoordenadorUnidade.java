package br.gov.rn.saogoncalo.telecentro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class CoordenadorUnidade extends Coordenador {

	private Long idCoordenadorUnidade;
	private Unidade unidade;
	
}
