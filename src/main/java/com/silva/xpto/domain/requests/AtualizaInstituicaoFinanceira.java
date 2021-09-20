package com.silva.xpto.domain.requests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtualizaInstituicaoFinanceira {

  private String cpfCnpj;
  private String codigoBanco;
  private Integer numeroConta;
  private Integer agencia;
  private LocalDate dataTransacao;
  private Double valor;
}