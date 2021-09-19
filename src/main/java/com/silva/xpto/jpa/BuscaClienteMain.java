package com.silva.xpto.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.silva.xpto.XptoProjectApplication;
import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.repository.ClienteRepository;

public class BuscaClienteMain{
	
	public static void main(String[] args) {
		ApplicationContext applicationContext  = new SpringApplicationBuilder(XptoProjectApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		ClienteRepository  ClienteRepository  = applicationContext.getBean(ClienteRepository.class);
		
		Cliente cliente = ClienteRepository.buscar(2L);
		
		System.out.println(cliente.getNome());
		
	}
	
}

