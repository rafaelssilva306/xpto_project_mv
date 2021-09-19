package com.silva.xpto.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.silva.xpto.XptoProjectApplication;
import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.repository.ClienteRepository;

public class InclusaoCliente {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext  = new SpringApplicationBuilder(XptoProjectApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		ClienteRepository  ClienteRepository = applicationContext.getBean(ClienteRepository.class);
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("Vitor Farias");
		cliente1.setCpfCnpj("35468851456");
		cliente1.setCep("08764020");
		cliente1.setCidade("São Paulo");
		cliente1.setEstado("São Paulo");
		cliente1.setBairro("Centro");
		cliente1.setRua("Rua 8 de Novembro");
		cliente1.setNumero(25);
		cliente1.setComplemento("Casa 2");
		//cliente1.setAberturaConta(Date.parse(null)););
		//cliente1.setDataCadastro();
		cliente1.setSaldoInicial(255.00);
		
		ClienteRepository .salvar(cliente1);
		
	}
}