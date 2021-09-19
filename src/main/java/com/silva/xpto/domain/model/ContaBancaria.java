package com.silva.xpto.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

	
	@Data
	@Entity
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	@Table(name = "conta_bancaria")
	public class ContaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_conta_bancaria")
	private Long idContaBancaria;
	private String nome;
	
	@Column(name = "codigo_banco")
	private String codigoBanco;
	
	@Column(name = "numero_conta")
	private Integer numeroConta;
	private Integer agencia;

	public ContaBancaria() {
	}

	
}
