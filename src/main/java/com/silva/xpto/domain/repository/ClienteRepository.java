package com.silva.xpto.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silva.xpto.domain.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
  Optional<Cliente> findByCpfCnpj(String cpfCnpj);
}
