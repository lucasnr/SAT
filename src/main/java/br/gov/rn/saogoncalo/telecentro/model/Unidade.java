package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "UNIDADE")
public class Unidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT")
	private Long id;
	private String nome;
	@Column(name = "QUANTIDADE_EQUIPAMENTOS")
	private Integer quantidadeEquipamentos;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ENDERECO_ID")
	private Endereco endereco;

}
