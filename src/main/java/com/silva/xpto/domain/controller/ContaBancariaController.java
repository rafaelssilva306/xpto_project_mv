package com.silva.xpto.domain.controller;

import java.util.List;
import java.util.Optional;

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

import com.silva.xpto.domain.service.ContaBancariaService;
import com.silva.xpto.domain.xpto.ContaBancariaDTO;

@RestController
@RequestMapping("api/v1/conta-bancaria")
public class ContaBancariaController {
  @Autowired 
  ContaBancariaService service;

  @GetMapping()
  public ResponseEntity<?> retornaTodos() {
    List<ContaBancariaDTO> listaContaBancariaDTO = service.retornaTodos();

    if (listaContaBancariaDTO.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    } else {
      return new ResponseEntity<>(listaContaBancariaDTO, HttpStatus.OK);
    }
  }

  @GetMapping(path = "/{id}")
  public ResponseEntity<?> retornaPorId(@PathVariable Integer id) {
    Optional<ContaBancariaDTO> contaBancariaDTO = service.retornaPorId(id);

    if (contaBancariaDTO.isPresent()) {
      return new ResponseEntity<>(contaBancariaDTO, HttpStatus.OK);

    } else {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
  }

  @PostMapping()
  public ResponseEntity<?> gravarContaBancaria(@RequestBody  ContaBancariaDTO request) {
    ContaBancariaDTO contaBancariaDTO = service.gravarContaBancaria(request);
      
    return new ResponseEntity<>(contaBancariaDTO, HttpStatus.CREATED);

  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<?> atualizarContaBancaria(@PathVariable Integer id, @RequestBody ContaBancariaDTO request) {
	  ContaBancariaDTO contaBancariaDTO = service.atualizarContaBancaria(id, request);

    if (contaBancariaDTO != null) {
      return new ResponseEntity<>(contaBancariaDTO, HttpStatus.OK);

    } else {
      return new ResponseEntity<>(request, HttpStatus.NOT_MODIFIED);
    }
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> apagarContaBancaria(@PathVariable Integer id) {    
    return new ResponseEntity<>(service.apagarContaBancaria(id), HttpStatus.OK); 
  }
  
}
