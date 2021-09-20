package com.silva.xpto.domain.relatorios;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RelatorioReceitaEmpresa {
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private List<RelatorioReceitaEmpresaAux> cliente;
	private double totalReceita;
}
