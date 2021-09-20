package com.silva.xpto.domain.service;

import java.util.List;
import java.util.Optional;

import com.silva.xpto.domain.xpto.ClienteDTO;

public interface ClienteService {

	  List<ClienteDTO> retornaTodos();

	  Optional<ClienteDTO> retornaPorid(Integer id);

	  ClienteDTO salvarCliente(ClienteDTO request);

	  ClienteDTO alterarCliente(Integer id, ClienteDTO clienteDTO);

	  String apagarCliente(Integer id);  
	  
	}