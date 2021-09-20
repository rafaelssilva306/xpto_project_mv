package com.silva.xpto.domain.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
	

	@Data
	@EqualsAndHashCode(onlyExplicitlyIncluded = true)
	@Entity(name = "cliente")
	@Table(name = "cliente")
	public class Cliente {
		
		@Id
		@Column(name = "id_cliente")
		@EqualsAndHashCode.Include
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer idCliente;
		
		@Column(name = "nome")
	    private String nome;
	    
	    @Column(name = "cpf_cnpj")
	    private String cpfCnpj;
	    
	    private String bairro;
	    private String estado;
	    private String cidade;
	    private Integer numero;
	    private String rua;
	    private String cep;
	    private String complemento;
	    private String telefone;

		@Column(name = "data_cadastro")
	    private LocalDate dataCadastro;
	    
	    @Column(name = "saldo_inicial")
	    private Double saldoInicial;
	    
	    private Date aberturaConta;
	    
}
