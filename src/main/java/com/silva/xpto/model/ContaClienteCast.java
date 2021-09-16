package com.silva.xpto.model;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ContaClienteCast implements Serializable {
	  private static final long serialVersionUID = 1L;
	  
	  @ManyToOne
	  @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
	  private Cliente cliente;

	  @ManyToOne
	  @JoinColumn(name = "id_conta_bancaria", referencedColumnName = "id_conta_bancaria")
	  private ContaBancaria contaBancaria;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	  
	  
}
