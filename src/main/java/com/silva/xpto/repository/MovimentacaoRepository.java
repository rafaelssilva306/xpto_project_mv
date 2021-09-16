package com.silva.xpto.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.silva.xpto.model.Movimentacoes;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacoes, Integer>{
  @Query(value = "select * from XPTO.MOVIMENTACAO m where m.ID_CLIENTE = :idCliente",
        nativeQuery = true)
  List<Movimentacoes> listaPorIdCliente(@Param("idCliente") Integer idCliente);

  @Query(value = "select * from XPTO.MOVIMENTACAO m where m.ID_CLIENTE = :idCliente and m.DATA BETWEEN TO_DATE(:dataInicial,'YYYY-MM-DD') and TO_DATE(:dataFinal,'YYYY-MM-DD')",
        nativeQuery = true)
  List<Movimentacoes> listaPorIdClienteComFiltroPorPeriodo(@Param("idCliente") Integer idCliente, 
                                                          @Param("dataInicial") String dataInicial,
                                                          @Param("dataFinal") String dataFinalAjustadaConvertida);

  @Query(value = "select * from XPTO.MOVIMENTACAO m where m.ID_CONTA_BANCARIA = :idContaBancaria",
      	nativeQuery = true)
  List<Movimentacoes> listaPorIdContaBancaria(@Param("idContaBancaria") Integer idContaBancaria);                                                          

  List<Movimentacoes> findByDataBetween(LocalDate dataInicial, LocalDate dataFinal);

}

