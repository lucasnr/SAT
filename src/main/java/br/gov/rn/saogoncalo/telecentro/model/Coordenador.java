package br.gov.rn.saogoncalo.telecentro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "COORDENADOR")
@PrimaryKeyJoinColumn(name = "USUARIO_ID")
public class Coordenador extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Coordenador(Perfil perfil) {
		super(perfil);
	}
}
