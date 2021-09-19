package com.silva.xpto.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
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

	public Long getIdContaBancaria() {
		return idContaBancaria;
	}

	public void setIdContaBancaria(Long idContaBancaria) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idContaBancaria == null) ? 0 : idContaBancaria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaBancaria other = (ContaBancaria) obj;
		if (idContaBancaria == null) {
			if (other.idContaBancaria != null)
				return false;
		} else if (!idContaBancaria.equals(other.idContaBancaria))
			return false;
		return true;
	}
	
	
}
