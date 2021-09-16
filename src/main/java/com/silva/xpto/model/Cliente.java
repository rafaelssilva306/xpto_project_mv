package com.silva.xpto.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "cliente")
	public class Cliente {
		
		@Id
		@GeneratedValue(generator = "cliente_seq")
		@Column(name = "id_cliente")
		private Integer id;
		
	    private String nome;
	    
	    @Column(name = "cpf_cnpj")
	    private String cpfCnpj;
	    
	    private String endereco;
	    private String bairro;
	    private String cidade;
	    private Integer numero;
	    private Integer cep;
	    private String complemento;
	    private String telefone;
	    
	    
	    @Column(name = "data_cadastro")
	    private LocalDate dataCadastro;
	    
	    @Column(name = "saldo_inicial")
	    private Double saldoInicial;
	    
	    private Date aberturaConta;
	    
	    public Cliente() {
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getCpfCnpj() {
			return cpfCnpj;
		}

		public void setCpfCnpj(String cpfCnpj) {
			this.cpfCnpj = cpfCnpj;
		}

		public String getEndereco() {
			return endereco;
		}

		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}

		public String getBairro() {
			return bairro;
		}

		public void setBairro(String bairro) {
			this.bairro = bairro;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public Integer getNumero() {
			return numero;
		}

		public void setNumero(Integer numero) {
			this.numero = numero;
		}

		public Integer getCep() {
			return cep;
		}

		public void setCep(Integer cep) {
			this.cep = cep;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public LocalDate getDataCadastro() {
			return dataCadastro;
		}

		public void setDataCadastro(LocalDate dataCadastro) {
			this.dataCadastro = dataCadastro;
		}

		public Double getSaldoInicial() {
			return saldoInicial;
		}

		public void setSaldoInicial(Double saldoInicial) {
			this.saldoInicial = saldoInicial;
		}

		public Date getAberturaConta() {
			return aberturaConta;
		}

		public void setAberturaConta(Date aberturaConta) {
			this.aberturaConta = aberturaConta;
		}
	    
	    
	
}
