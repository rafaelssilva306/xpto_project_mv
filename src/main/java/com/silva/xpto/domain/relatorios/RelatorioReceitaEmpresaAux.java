package com.silva.xpto.domain.relatorios;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class RelatorioReceitaEmpresaAux {
  private String nome;
  private Integer quantidadeTransacoes;
  private double valorTransacoes;
}
