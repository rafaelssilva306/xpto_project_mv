package com.silva.xpto.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.xpto.domain.exception.ServerException;
import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.model.ContaBancaria;
import com.silva.xpto.domain.model.Transacao;
import com.silva.xpto.domain.repository.ClienteRepository;
import com.silva.xpto.domain.repository.ContaBancariaRepository;
import com.silva.xpto.domain.repository.TransacaoRepository;
import com.silva.xpto.domain.requests.AtualizaInstituicaoFinanceira;
import com.silva.xpto.domain.xpto.TransacaoDTO;

@Service
public class TransacaoServiceImpl implements TransacaoService{
  @Autowired
  TransacaoRepository repository;
  
  @Autowired
  ClienteRepository clienteRepository;

  @Autowired
  ContaBancariaRepository contaBancariaRepository;

  @Override
  public List<TransacaoDTO> retornaTodos() {
    try {
      List<Transacao> listaTransacao = repository.findAll();

      List<TransacaoDTO> listaTransacaoDTO = listaTransacao.stream()
                                                  .map(list -> new ModelMapper().map(list, TransacaoDTO.class))
                                                  .collect(Collectors.toList());

      return listaTransacaoDTO;

    } catch (Exception e) {
      throw new ServerException();
    }    
  }

  @Override
  public Optional<TransacaoDTO> retornaPorId(Integer id) {
    try {
      Optional<Transacao> transacao = repository.findById(id);

      if (transacao.isPresent()) {
        TransacaoDTO TransacaoDTO = new ModelMapper().map(transacao.get(), TransacaoDTO.class);
        return Optional.of(TransacaoDTO);
        
      } else {
        return Optional.empty();
      }

    } catch (Exception e) {
      throw new ServerException();
    }
    
  }

  @Override
  public TransacaoDTO gravarTransacao(AtualizaInstituicaoFinanceira request) {
    try {
      Optional<Cliente> cliente = clienteRepository.findByCpfCnpj(request.getCpfCnpj());
      Optional<ContaBancaria> contaBancaria = contaBancariaRepository.findByCodigoBancoAndNumeroContaAndAgencia(request.getCodigoBanco(), request.getNumeroConta(), request.getAgencia());

      if ((cliente.isPresent()) && (contaBancaria.isPresent())) {
    	  Transacao transacao = new Transacao();
    	  transacao.setCliente(cliente.get());
    	  transacao.setContaBancaria(contaBancaria.get());
    	  transacao.setValor(request.getValor());
    	  transacao.setData(request.getDataTransacao());

    	  transacao = repository.save(transacao);

        return new ModelMapper().map(transacao, TransacaoDTO.class);

      } else {
        return null;
      }
    } catch (Exception e) {
      throw new ServerException();
    }
  }



  
}
