package com.silva.xpto.model;

import java.math.BigDecimal;
import java.util.Date;

public class Taxacao {
	
		private Integer id;
	    private Integer cobradoID;
	    private Integer transacaoID;
	    private BigDecimal valor;
	    private Date cobradaEm;
	    
	    public Taxacao() {
	    }

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getCobradoID() {
			return cobradoID;
		}

		public void setCobradoID(Integer cobradoID) {
			this.cobradoID = cobradoID;
		}

		public Integer getTransacaoID() {
			return transacaoID;
		}

		public void setTransacaoID(Integer transacaoID) {
			this.transacaoID = transacaoID;
		}

		public BigDecimal getValor() {
			return valor;
		}

		public void setValor(BigDecimal valor) {
			this.valor = valor;
		}

		public Date getCobradaEm() {
			return cobradaEm;
		}

		public void setCobradaEm(Date cobradaEm) {
			this.cobradaEm = cobradaEm;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((cobradaEm == null) ? 0 : cobradaEm.hashCode());
			result = prime * result + ((cobradoID == null) ? 0 : cobradoID.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((transacaoID == null) ? 0 : transacaoID.hashCode());
			result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
			Taxacao other = (Taxacao) obj;
			if (cobradaEm == null) {
				if (other.cobradaEm != null)
					return false;
			} else if (!cobradaEm.equals(other.cobradaEm))
				return false;
			if (cobradoID == null) {
				if (other.cobradoID != null)
					return false;
			} else if (!cobradoID.equals(other.cobradoID))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (transacaoID == null) {
				if (other.transacaoID != null)
					return false;
			} else if (!transacaoID.equals(other.transacaoID))
				return false;
			if (valor == null) {
				if (other.valor != null)
					return false;
			} else if (!valor.equals(other.valor))
				return false;
			return true;
		}
	    
	    
}
