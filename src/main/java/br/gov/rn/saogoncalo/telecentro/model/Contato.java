package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CONTATO")
public class Contato {

	@Id
	@Column(name = "PESSOA_ID", columnDefinition="INT")
	private Long id;
	private String email;
	private String telefone;
}
