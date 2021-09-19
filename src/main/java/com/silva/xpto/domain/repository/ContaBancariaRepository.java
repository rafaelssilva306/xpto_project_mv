package com.silva.xpto.domain.repository;

import java.util.List;

import com.silva.xpto.domain.model.ContaBancaria;

public interface ContaBancariaRepository {
	
	List<ContaBancaria> listar();
	ContaBancaria buscar(Long id);
	ContaBancaria salvar(ContaBancaria contabancaria);
	void remover(ContaBancaria contabancaria);
	
}
