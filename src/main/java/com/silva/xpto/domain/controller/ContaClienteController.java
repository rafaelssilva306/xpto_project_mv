package com.silva.xpto.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silva.xpto.domain.requests.AtualizaContaCliente;
import com.silva.xpto.domain.service.ContaClienteService;
import com.silva.xpto.domain.xpto.ContaClienteDTO;

@RestController
@RequestMapping("api/v1/conta-cliente")
public class ContaClienteController {
	@Autowired
	ContaClienteService service;

	@GetMapping(path = "/{idCliente}")
	public ResponseEntity<?> retornaContasPorCliente(@PathVariable Integer idCliente) {
		List<ContaClienteDTO> listaContaClienteDTO = service.retornaContasPorCliente(idCliente);

		if (listaContaClienteDTO.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} else {
			return new ResponseEntity<>(listaContaClienteDTO, HttpStatus.OK);
		}

	}

	@DeleteMapping()
	public ResponseEntity<?> apagarContaCliente(@RequestBody AtualizaContaCliente request) {
		return new ResponseEntity<>(service.apagarContaCliente(request.getIdCliente(), request.getIdContaBancaria()),
				HttpStatus.OK);
	}

}
