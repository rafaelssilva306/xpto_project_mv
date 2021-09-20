package com.silva.xpto.domain.controller;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silva.xpto.domain.requests.AtualizarCliente;
import com.silva.xpto.domain.service.ClienteService;
import com.silva.xpto.domain.xpto.ClienteDTO;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {
	@Autowired
	ClienteService service;

	@GetMapping
	public ResponseEntity<?> retornaTodos() {
		List<ClienteDTO> listaClienteDTO = service.retornaTodos();

		if (listaClienteDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} else {
			return new ResponseEntity<>(listaClienteDTO, HttpStatus.OK);
		}

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> retornaPorId(@PathVariable Integer id) {
		Optional<ClienteDTO> clienteDTO = service.retornaPorid(id);

		if (clienteDTO.isPresent()) {
			return new ResponseEntity<>(clienteDTO.get(), HttpStatus.OK);

		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping
	public ResponseEntity<?> gravarCliente(@RequestBody ClienteDTO request) {
		ClienteDTO clienteDTO = service.salvarCliente(request);

		return new ResponseEntity<>(clienteDTO, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<?> alterarCliente(@PathVariable Integer id, @RequestBody AtualizarCliente request) {
		ClienteDTO clienteDTO = new ModelMapper().map(request, ClienteDTO.class);
		clienteDTO = service.alterarCliente(id, clienteDTO);

		if (clienteDTO != null) {
			return new ResponseEntity<>(clienteDTO, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(clienteDTO, HttpStatus.NOT_MODIFIED);
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> apagarCliente(@PathVariable Integer id) {
		return new ResponseEntity<>(service.apagarCliente(id), HttpStatus.OK);
	}
}