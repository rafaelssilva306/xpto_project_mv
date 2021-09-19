package com.silva.xpto.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.repository.ClienteRepository;

@Component
public class ClienteRepositoryImpl implements ClienteRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cliente> listar(){
		return manager.createQuery("from cliente", Cliente.class).getResultList();
	}
	
	@Override
	public Cliente buscar(Long id) {
		//buscar por id
		return manager.find(Cliente.class, id);
	}
	
	@Transactional
	@Override
	public Cliente salvar(Cliente cliente) {
		//Inserir dados	
		return manager.merge(cliente);
	}
	
	@Transactional
	@Override
	public void remover(Cliente cliente) {
		//remover cliente
		cliente = buscar(cliente.getId());
		manager.remove(cliente);
	}
}
