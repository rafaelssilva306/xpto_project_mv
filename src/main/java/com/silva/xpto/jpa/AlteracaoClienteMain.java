package com.silva.xpto.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.silva.xpto.XptoProjectApplication;
import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.repository.ClienteRepository;

public class AlteracaoClienteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext  = new SpringApplicationBuilder(XptoProjectApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		ClienteRepository ClienteRepository  = applicationContext.getBean(ClienteRepository .class);
		
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNome("Vitor Mariano");
		cliente.setCpfCnpj("35468851456");
		cliente.setCep("08764020");
		cliente.setCidade("São Paulo");
		cliente.setEstado("São Paulo");
		cliente.setBairro("Centro");
		cliente.setRua("Rua 8 de Novembro");
		cliente.setNumero(25);
		cliente.setComplemento("Casa 2");
		//cliente1.setAberturaConta(Date.parse(null)););
		//cliente1.setDataCadastro();
		cliente.setSaldoInicial(255.00);
		
		ClienteRepository.salvar(cliente);
		
	}
}