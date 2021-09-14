package com.silva.xpto.model;

import java.util.Date;

public class Cliente {

		private Integer id;
	    private String nome;
	    private Integer enderecoID;
	    private Date cadastradaEm;
	    
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

		public Integer getEnderecoID() {
			return enderecoID;
		}

		public void setEnderecoID(Integer enderecoID) {
			this.enderecoID = enderecoID;
		}

		public Date getCadastradaEm() {
			return cadastradaEm;
		}

		public void setCadastradaEm(Date cadastradaEm) {
			this.cadastradaEm = cadastradaEm;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cadastradaEm == null) ? 0 : cadastradaEm.hashCode());
			result = prime * result + ((enderecoID == null) ? 0 : enderecoID.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
			if (cadastradaEm == null) {
				if (other.cadastradaEm != null)
					return false;
			} else if (!cadastradaEm.equals(other.cadastradaEm))
				return false;
			if (enderecoID == null) {
				if (other.enderecoID != null)
					return false;
			} else if (!enderecoID.equals(other.enderecoID))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (nome == null) {
				if (other.nome != null)
					return false;
			} else if (!nome.equals(other.nome))
				return false;
			return true;
		}
	    

	    
}
