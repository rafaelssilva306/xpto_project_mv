package com.silva.xpto.domain.xpto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ContaBancariaDTO {
  private Integer idContaBancaria;
  private String nome;
  private String codigoBanco;
  private Integer numeroConta;
  private Integer agencia;  
}
