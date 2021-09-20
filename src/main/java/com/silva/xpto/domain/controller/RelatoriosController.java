package com.silva.xpto.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silva.xpto.domain.relatorios.RelatorioReceitaEmpresa;
import com.silva.xpto.domain.relatorios.RelatorioSaldoCliente;
import com.silva.xpto.domain.service.RelatorioService;

@RestController
@RequestMapping("api/v1/relatorio")
public class RelatoriosController {
  @Autowired
  RelatorioService service;
  
  @GetMapping(path = "/relatorio_saldo_cliente/{idCliente}")
  public ResponseEntity<?> relatorioSaldoCliente(@PathVariable Integer idCliente) {
    RelatorioSaldoCliente relatorio = service.relatorioSaldoCliente(idCliente);

    if (relatorio != null) {
      return new ResponseEntity<>(relatorio, HttpStatus.OK);
      
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/relatorio_saldo_cliente_periodo/{idCliente}/{dataInicial}/{dataFinal}")
  public ResponseEntity<?> relatorioDeSaldoClientePeriodo(@PathVariable Integer idCliente, @PathVariable String dataInicial, @PathVariable String dataFinal) {

    RelatorioSaldoCliente relatorio = service.relatorioSaldoClientePorPeriodo(idCliente, dataInicial, dataFinal);

    if (relatorio != null) {
      return new ResponseEntity<>(relatorio, HttpStatus.OK);
      
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping(path = "/relatorio_receita_empresa/{dataInicial}/{dataFinal}")
  public ResponseEntity<?> relatorioDeReceitasDaEmpresa(@PathVariable String dataInicial, @PathVariable String dataFinal) {
    RelatorioReceitaEmpresa relatorio = service.relatorioReceitaEmpresa(dataInicial, dataFinal);

    if (relatorio != null) {
      return new ResponseEntity<>(relatorio, HttpStatus.OK);
      
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
  
}