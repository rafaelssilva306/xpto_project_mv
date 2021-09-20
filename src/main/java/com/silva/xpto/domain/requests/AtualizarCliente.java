package com.silva.xpto.domain.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtualizarCliente {
  private String nome;
  private String bairro;
  private String cidade;
  private Integer numero;
  private Integer cep;
  private String complemento;
  private String telefone;
  private String estado;
}
