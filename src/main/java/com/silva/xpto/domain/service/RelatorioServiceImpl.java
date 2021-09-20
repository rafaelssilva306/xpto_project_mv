package com.silva.xpto.domain.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.model.Transacao;
import com.silva.xpto.domain.relatorios.RelatorioReceitaEmpresa;
import com.silva.xpto.domain.relatorios.RelatorioReceitaEmpresaAux;
import com.silva.xpto.domain.relatorios.RelatorioSaldoCliente;
import com.silva.xpto.domain.relatorios.ValorTransacao;
import com.silva.xpto.domain.repository.ClienteRepository;
import com.silva.xpto.domain.repository.TransacaoRepository;
import com.silva.xpto.domain.xpto.ClienteDTO;

@Service
public class RelatorioServiceImpl extends ValorTransacao implements RelatorioService {
  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  TransacaoRepository transacaoRepository;

  @Override
  public RelatorioSaldoCliente relatorioSaldoCliente(Integer idCliente) {
    Optional<Cliente> cliente = clienteRepository.findById(idCliente);
    List<Transacao> listaTransacao = transacaoRepository.listaPorIdCliente(idCliente);

    if ((cliente.isPresent()) && (listaTransacao.size() != 0)) {
      String dataInicial = cliente.get().getDataCadastro().format(DateTimeFormatter.ISO_LOCAL_DATE);
      String dataFinal = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);

      return montarRelatorioPorCliente(cliente.get(), listaTransacao, dataInicial, dataFinal);
      
    } else {
      return null;
    }
  }

  @Override
  public RelatorioSaldoCliente relatorioSaldoClientePorPeriodo(Integer idCliente, String dataInicial, String dataFinal) {
    Optional<Cliente> cliente = clienteRepository.findById(idCliente);

    LocalDate dataFinalAjustada = LocalDate.parse(dataFinal);
    dataFinalAjustada = dataFinalAjustada.plusDays(1);
    String dataFinalAjustadaConvertida = dataFinalAjustada.format(DateTimeFormatter.ISO_LOCAL_DATE);

    List<Transacao> listaTransacao = transacaoRepository.listaPorIdClienteComFiltroPorPeriodo(idCliente, dataInicial, dataFinalAjustadaConvertida);

    if ((cliente.isPresent()) && (listaTransacao.size() != 0)) {
      return montarRelatorioPorCliente(cliente.get(), listaTransacao, dataInicial, dataFinal);
      
    } else {
      return null;
    }
  }

  private RelatorioSaldoCliente montarRelatorioPorCliente(Cliente cliente, List<Transacao> listaTransacao, String dataInicial, String dataFinal){
    RelatorioSaldoCliente relatorio = new RelatorioSaldoCliente();
    
    relatorio.setDataInicial(LocalDate.parse(dataInicial));
    relatorio.setDataFinal(LocalDate.parse(dataFinal));
    
    relatorio.setCliente(new ModelMapper().map(cliente, ClienteDTO.class));

    listaTransacao.stream().forEach(transacao -> {
      if (transacao.getValor() > 0) {
        relatorio.setTransacaoCredito(relatorio.getTransacaoCredito() + transacao.getValor());

      } else {
        relatorio.setTransacaoDebito(relatorio.getTransacaoDebito() + transacao.getValor());
      }        
    });

    relatorio.setTotalTransacao(relatorio.getTransacaoCredito() + relatorio.getTransacaoDebito());

    relatorio.setQuantidadeTransacoes(listaTransacao.size());
    
    Double valorPorTransacao = valorTransacao(relatorio.getQuantidadeTransacoes());

    relatorio.setValorCobradoPelasTransacoes(valorPorTransacao);

    relatorio.setValorTotalPagoPelasTransacoes(relatorio.getQuantidadeTransacoes() * valorPorTransacao);

    relatorio.setSaldoAtual((cliente.getSaldoInicial() + relatorio.getTotalTransacao()) - relatorio.getValorTotalPagoPelasTransacoes());

    return relatorio;
  }

  @Override
  public RelatorioReceitaEmpresa relatorioReceitaEmpresa(String dataInicial, String dataFinal) { 
    RelatorioReceitaEmpresa relatorio = new RelatorioReceitaEmpresa();
    List<RelatorioReceitaEmpresaAux> listaRelatorioReceitaEmpresaAuxiliar = new ArrayList<>();
    
    LocalDate dataInicialConvertida = LocalDate.parse(dataInicial);
    LocalDate dataFinalConvertida = LocalDate.parse(dataFinal);   

    List<Transacao> listaTransacao = transacaoRepository.findByDataBetween(dataInicialConvertida, dataFinalConvertida);  

    Map<Cliente, List<Transacao>> transacaoAgrupadoPorCliente = listaTransacao
                                                                  .stream()
                                                                  .collect(Collectors.groupingBy(Transacao::getCliente));                                                                

    transacaoAgrupadoPorCliente.entrySet().forEach(transacao ->{
      RelatorioReceitaEmpresaAux auxiliar = new RelatorioReceitaEmpresaAux();  
      
      auxiliar.setNome(transacao.getKey().getNome());      
      auxiliar.setQuantidadeTransacoes(transacao.getValue().size());
      auxiliar.setValorTransacoes(auxiliar.getQuantidadeTransacoes() * valorTransacao(auxiliar.getQuantidadeTransacoes()));

      listaRelatorioReceitaEmpresaAuxiliar.add(auxiliar);

      relatorio.setTotalReceita(relatorio.getTotalReceita() + auxiliar.getValorTransacoes());
    });            
    
    relatorio.setDataInicial(dataInicialConvertida);
    relatorio.setDataFinal(dataFinalConvertida);  
    relatorio.setCliente(listaRelatorioReceitaEmpresaAuxiliar);

    return relatorio;
  }  

  
  
}
