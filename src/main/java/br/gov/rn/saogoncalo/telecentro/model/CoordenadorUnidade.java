package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "COORDENADOR_UNIDADE")
@PrimaryKeyJoinColumn(name = "COORDENADOR_ID")
public class CoordenadorUnidade extends Coordenador {

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIDADE_ID")
	private Unidade unidade;

}
