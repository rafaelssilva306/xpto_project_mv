package com.silva.xpto.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta_bancaria")
public class ContaBancaria {

	@Id
	@GeneratedValue(generator = "conta_bancaria_seq")
	@Column(name = "id_conta_bancaria")
	private Integer idContaBancaria;
	private String nome;
	@Column(name = "codigo_banco")
	private String codigoBanco;
	@Column(name = "numero_conta")
	private Integer numeroConta;
	private Integer agencia;

	public ContaBancaria() {
	}

	public Integer getIdContaBancaria() {
		return idContaBancaria;
	}

	public void setIdContaBancaria(Integer idContaBancaria) {
		this.idContaBancaria = idContaBancaria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigoBanco() {
		return codigoBanco;
	}

	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}
	
	
}
