package com.silva.xpto.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silva.xpto.model.ContaBancaria;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Integer>{
	  Optional<ContaBancaria> findByCodigoBancoAndNumeroContaAndAgencia(String codigoBanco, Integer numeroConta, Integer Agencia);
}
