package com.silva.xpto.domain.service;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.silva.xpto.domain.xpto.ContaBancariaDTO;

@Service
public interface ContaBancariaService {

	  List<ContaBancariaDTO> retornaTodos();

	  Optional<ContaBancariaDTO> retornaPorId(Integer id);

	  ContaBancariaDTO gravarContaBancaria(ContaBancariaDTO request);

	  ContaBancariaDTO atualizarContaBancaria(Integer id, ContaBancariaDTO request);

	  String apagarContaBancaria(Integer id);
	  
	}
