package com.silva.xpto.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.silva.xpto.domain.model.ContaBancaria;
import com.silva.xpto.domain.repository.ContaBancariaRepository;

@Component
public class ContaBancariaRepositoryImpl implements ContaBancariaRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<ContaBancaria> listar(){
		return manager.createQuery("from conta_bancaria", ContaBancaria.class).getResultList();
	}
	@Override
	public ContaBancaria buscar(Long idContaBancaria) {
		//buscar por id
		return manager.find(ContaBancaria.class, idContaBancaria);
	}
	
	@Transactional
	@Override
	public ContaBancaria salvar(ContaBancaria contaBancaria) {
		//Inserir dados	
		return manager.merge(contaBancaria);
	}
	
	@Transactional
	@Override
	public void remover(ContaBancaria contaBancaria) {
		//remover conta bancaria
		contaBancaria = buscar(contaBancaria.getIdContaBancaria());
		manager.remove(contaBancaria);
	}
}
