package com.silva.xpto.domain.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtualizaContaCliente {
  private Integer idCliente;
  private Integer idContaBancaria;
}
