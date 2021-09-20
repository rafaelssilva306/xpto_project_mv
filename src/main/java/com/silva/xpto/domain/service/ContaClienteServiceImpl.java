package com.silva.xpto.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.xpto.domain.exception.ServerException;
import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.model.ContaBancaria;
import com.silva.xpto.domain.model.ContaCliente;
import com.silva.xpto.domain.model.ContaClienteCast;
import com.silva.xpto.domain.repository.ClienteRepository;
import com.silva.xpto.domain.repository.ContaBancariaRepository;
import com.silva.xpto.domain.repository.ContaClienteRepository;
import com.silva.xpto.domain.xpto.ContaClienteDTO;

@Service
public class ContaClienteServiceImpl implements ContaClienteService {
	@Autowired
	ContaClienteRepository repository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ContaBancariaRepository contaBancariaRepository;

	@Override
	public List<ContaClienteDTO> retornaContasPorCliente(Integer idCliente) {
		try {
			List<ContaCliente> listaContaCliente = repository.findByIdCliente(idCliente);

			List<ContaClienteDTO> listaContaClienteDTO = listaContaCliente.stream()
					.map(list -> new ModelMapper().map(list, ContaClienteDTO.class)).collect(Collectors.toList());

			return listaContaClienteDTO;

		} catch (Exception e) {
			throw new ServerException();
		}
	}

	@Override
	public ContaClienteDTO gravaContaCliente(Integer idCliente, Integer idContaBancaria) {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(idCliente);
			Optional<ContaBancaria> contaBancaria = contaBancariaRepository.findById(idContaBancaria);

			if ((cliente.isPresent()) && (contaBancaria.isPresent())) {
				ModelMapper mapper = new ModelMapper();

				ContaClienteCast contaClienteCast = new ContaClienteCast(cliente.get(), contaBancaria.get());
				ContaClienteDTO contaClienteDto = new ContaClienteDTO(contaClienteCast);

				ContaCliente contaCliente = mapper.map(contaClienteDto, ContaCliente.class);
				contaCliente = repository.save(contaCliente);

				return mapper.map(contaCliente, ContaClienteDTO.class);

			} else {
				return null;
			}

		} catch (Exception e) {
			throw new ServerException();
		}

	}

	@Override
	public String apagarContaCliente(Integer idCliente, Integer idContaBancaria) {
		try {
			repository.apagarRegistro(idCliente, idContaBancaria);
			return "O vínculo da conta bancaria foi removido com sucesso";

		} catch (Exception e) {
			throw new ServerException();
		}
	}

}
