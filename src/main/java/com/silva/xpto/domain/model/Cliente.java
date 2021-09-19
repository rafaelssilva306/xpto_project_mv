package com.silva.xpto.domain.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	    
	    public Cliente(Long id, String nome, String rua, String estado, String cpfCnpj, String bairro, String cidade,
					Integer numero, String cep, String complemento, String telefone, Date dataCadastro,
					Double saldoInicial, Date aberturaConta) {
				super();
				this.id = id;
				this.nome = nome;
				this.cpfCnpj = cpfCnpj;
				this.bairro = bairro;
				this.cidade = cidade;
				this.estado = estado;
				this.numero = numero;
				this.rua = rua;
				this.cep = cep;
				this.complemento = complemento;
				this.telefone = telefone;
				this.dataCadastro = dataCadastro;
				this.saldoInicial = saldoInicial;
				this.aberturaConta = aberturaConta;
			}
	    
	    public Cliente() {
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
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

		public String getCep(String cep) {
			return cep;
		}

		public void setCep(String cep) {
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

		public Date getDataCadastro() {
			return dataCadastro;
		}

		public void setDataCadastro(Date dataCadastro) {
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
		

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
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
			Cliente other = (Cliente) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
		
	
}
