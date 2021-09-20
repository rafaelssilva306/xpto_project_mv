package com.silva.xpto.domain.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.silva.xpto.domain.xpto.ContaClienteDTO;

@Service
public interface ContaClienteService {

	  List<ContaClienteDTO> retornaContasPorCliente(Integer idCliente);

	  ContaClienteDTO gravaContaCliente(Integer idCliente, Integer idContaBancaria);

	  String apagarContaCliente(Integer idCliente, Integer idContaBancaria);
	  
	}
