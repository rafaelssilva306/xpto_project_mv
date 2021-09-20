package com.silva.xpto.domain.relatorios;

import java.time.LocalDate;

import com.silva.xpto.domain.xpto.ClienteDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RelatorioSaldoCliente {
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private ClienteDTO cliente;
	private double transacaoCredito;
	private double transacaoDebito;
	private double totalTransacao;
	private Integer quantidadeTransacoes;
	private double valorCobradoPelasTransacoes;
	private double valorTotalPagoPelasTransacoes;
	private double saldoAtual;
}