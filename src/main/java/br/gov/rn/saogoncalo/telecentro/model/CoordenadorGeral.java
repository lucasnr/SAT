package br.gov.rn.saogoncalo.telecentro.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "COORDENADOR_GERAL")
@PrimaryKeyJoinColumn(name = "COORDENADOR_ID")
public class CoordenadorGeral extends Coordenador {
}
