package com.silva.xpto.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

	
	@Data
	@Entity
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	@Table(name = "conta_bancaria")
	public class ContaBancaria {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta_bancaria")
	private Integer idContaBancaria;
	private String nome;
	private Integer agencia;
	
	@Column(name = "numero_conta")
	private Integer numeroConta;
	
	@Column(name = "codigo_banco")
	private String codigoBanco;
	
}
