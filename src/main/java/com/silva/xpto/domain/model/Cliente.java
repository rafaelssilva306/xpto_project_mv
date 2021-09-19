package com.silva.xpto.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
	

	@Data
	@HashCodeAndEquals
	@Entity(name = "cliente")
	@Table(name = "cliente")
	public class Cliente {
		
		@Id
		@Column(name = "id_cliente")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
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
	    private Date dataCadastro;
	    
	    @Column(name = "saldo_inicial")
	    private Double saldoInicial;
	    
	    private Date aberturaConta;
	    
	    public Cliente() {
	    }


		
	
}
