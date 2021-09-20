package com.silva.xpto.domain.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silva.xpto.domain.exception.ServerException;
import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.repository.ClienteRepository;
import com.silva.xpto.domain.xpto.ClienteDTO;
import com.silva.xpto.domain.xpto.ContaBancariaDTO;
import com.silva.xpto.domain.service.ContaBancariaService;

@Service
public class ClienteServiceImpl implements ClienteService {
	@Autowired
	ClienteRepository repository;

	@Autowired
	ContaClienteService contaClienteService;
	
	@Autowired
	ContaBancariaService contaBancariaService;

	@Override
	public List<ClienteDTO> retornaTodos() {
		try {
			List<Cliente> listaCliente = repository.findAll();

			List<ClienteDTO> listaClienteDTO = listaCliente.stream()
					.map(dto -> new ModelMapper().map(dto, ClienteDTO.class)).collect(Collectors.toList());

			return listaClienteDTO;

		} catch (Exception e) {
			throw new ServerException();
		}
	}

	@Override
	public Optional<ClienteDTO> retornaPorid(Integer id) {
		try {
			Optional<Cliente> cliente = repository.findById(id);

			if (cliente.isPresent()) {
				ClienteDTO clienteDTO = new ModelMapper().map(cliente.get(), ClienteDTO.class);
				return Optional.of(clienteDTO);

			} else {
				return Optional.empty();
			}

		} catch (Exception e) {
			throw new ServerException();
		}
	}

	@Override
	public ClienteDTO salvarCliente(ClienteDTO request) {
		try {
			ModelMapper mapper = new ModelMapper();
			Cliente cliente = mapper.map(request, Cliente.class);

			if (cliente.getDataCadastro() == null) {
				cliente.setDataCadastro(LocalDate.now());
			}

			cliente = repository.save(cliente);

			Integer idCliente = cliente.getIdCliente();
			List<ContaBancariaDTO> listaContaBancaria = new ArrayList<>();

			request.getContasBancarias().forEach(conta -> {
				contaClienteService.gravaContaCliente(idCliente, conta.getIdContaBancaria());

				Optional<ContaBancariaDTO> contaBancariaDTO = contaBancariaService
						.retornaPorId(conta.getIdContaBancaria());
				listaContaBancaria.add(contaBancariaDTO.get());
			});

			ClienteDTO clienteDTO = mapper.map(cliente, ClienteDTO.class);
			clienteDTO.setContasBancarias(listaContaBancaria);

			return clienteDTO;

		} catch (Exception e) {
			throw new ServerException();
		}
	}

	@Override
	public ClienteDTO alterarCliente(Integer id, ClienteDTO clienteDTO) {
		Optional<ClienteDTO> clienteRetornadoDoBanco = retornaPorid(id);

		if (clienteRetornadoDoBanco.isPresent()) {
			ModelMapper mapper = new ModelMapper();
			Cliente cliente = mapper.map(clienteRetornadoDoBanco.get(), Cliente.class);

			if (clienteDTO.getNome() != null) {
				cliente.setNome(clienteDTO.getNome());
			}

			if (clienteDTO.getBairro() != null) {
				cliente.setBairro(clienteDTO.getBairro());
			}

			if (clienteDTO.getCidade() != null) {
				cliente.setCidade(clienteDTO.getCidade());
			}

			if (clienteDTO.getNumero() != null) {
				cliente.setNumero(clienteDTO.getNumero());
			}

			if (clienteDTO.getCep() != null) {
				cliente.setCep(clienteDTO.getCep());
			}

			if (clienteDTO.getComplemento() != null) {
				cliente.setComplemento(clienteDTO.getComplemento());
			}

			if (clienteDTO.getTelefone() != null) {
				cliente.setTelefone(clienteDTO.getTelefone());
			}

			try {
				cliente = repository.save(cliente);

			} catch (Exception e) {
				throw new ServerException();
			}

			return mapper.map(cliente, ClienteDTO.class);

		} else {
			return null;
		}
	}

	@Override
	public String apagarCliente(Integer id) {
		try {
			repository.deleteById(id);
			return "Cliente excluído com sucesso";

		} catch (Exception e) {
			throw new ServerException();
		}
	}

}