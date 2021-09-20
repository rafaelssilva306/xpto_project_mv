package com.silva.xpto.domain.xpto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public class ClienteDTO {
		
	private Integer idCliente;
	private String nome;
	private String telefone;
	private String cep;
	private String cpfCnpj;
	private String estado;
	private String cidade;
	private String bairro;
	private Integer numero;
	private String complemento;
	private LocalDate dataCadastro;
	private Double saldoInicial;

	private List<ContaBancariaDTO> contasBancarias;
}