package com.silva.xpto.domain.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.silva.xpto.domain.model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{
  @Query(value = "select * from XPTO.TRANSACAO m where m.ID_CLIENTE = :idCliente",
        nativeQuery = true)
  List<Transacao> listaPorIdCliente(@Param("idCliente") Integer idCliente);

  @Query(value = "select * from XPTO.TRANSACAO m where m.ID_CLIENTE = :idCliente and m.DATA BETWEEN TO_DATE(:dataInicial,'YYYY-MM-DD') and TO_DATE(:dataFinal,'YYYY-MM-DD')",
        nativeQuery = true)
  List<Transacao> listaPorIdClienteComFiltroPorPeriodo(@Param("idCliente") Integer idCliente, 
                                                          @Param("dataInicial") String dataInicial,
                                                          @Param("dataFinal") String dataFinalAjustadaConvertida);

  @Query(value = "select * from XPTO.Transacao m where m.ID_CONTA_BANCARIA = :idContaBancaria",
      	nativeQuery = true)
  List<Transacao> listaPorIdContaBancaria(@Param("idContaBancaria") Integer idContaBancaria);                                                          

  List<Transacao> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);

}