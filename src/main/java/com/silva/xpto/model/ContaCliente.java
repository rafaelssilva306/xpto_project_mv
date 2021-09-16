package com.silva.xpto.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "conta_cliente")
public class ContaCliente {
	@EmbeddedId
	private ContaClienteCast contaClienteCast;
}
