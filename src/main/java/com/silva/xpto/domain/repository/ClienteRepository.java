package com.silva.xpto.domain.repository;

import java.util.List;

import com.silva.xpto.domain.model.Cliente;

public interface ClienteRepository {
	
	List<Cliente> listar();
	Cliente buscar(Long id);
	Cliente salvar(Cliente cliente);
	void remover(Cliente cliente);
	
}
