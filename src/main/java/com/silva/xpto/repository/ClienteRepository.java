package com.silva.xpto.repository;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.silva.xpto.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
	public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	  Optional<Cliente> findByCpfCnpj(String cpfCnpj);
	}

