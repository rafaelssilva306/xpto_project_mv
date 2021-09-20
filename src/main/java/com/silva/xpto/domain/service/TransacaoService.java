package com.silva.xpto.domain.service;

import java.util.List;
import java.util.Optional;

import com.silva.xpto.domain.requests.AtualizaInstituicaoFinanceira;
import com.silva.xpto.domain.xpto.TransacaoDTO;

public interface TransacaoService {

	List<TransacaoDTO> retornaTodos();

	Optional<TransacaoDTO> retornaPorId(Integer id);

	TransacaoDTO gravarTransacao(AtualizaInstituicaoFinanceira request);

}