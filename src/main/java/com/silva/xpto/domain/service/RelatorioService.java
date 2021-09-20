package com.silva.xpto.domain.service;

import com.silva.xpto.domain.relatorios.RelatorioReceitaEmpresa;
import com.silva.xpto.domain.relatorios.RelatorioSaldoCliente;

public interface RelatorioService {

	  RelatorioSaldoCliente relatorioSaldoCliente(Integer idCliente);

	  RelatorioSaldoCliente relatorioSaldoClientePorPeriodo(Integer idCliente, String dataInicial, String dataFinal);

	  RelatorioReceitaEmpresa relatorioReceitaEmpresa(String dataInicial, String dataFinal);
	  
	}
