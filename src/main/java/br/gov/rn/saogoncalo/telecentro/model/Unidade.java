package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "UNIDADE")
public class Unidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIDADE_ID")
	private List<Turma> turmas;


	public Unidade() {
		this.endereco = new Endereco();
	}

}
