package com.silva.xpto.domain.xpto;

import java.time.LocalDate;

import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.model.ContaBancaria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransacaoDTO {
	private Integer idTransacao;
	private Cliente cliente;
	private ContaBancaria contaBancaria;
	private Double valor;
	private LocalDate data;
}