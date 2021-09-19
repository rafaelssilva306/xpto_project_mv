package com.silva.xpto.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.silva.xpto.XptoProjectApplication;
import com.silva.xpto.domain.model.Cliente;
import com.silva.xpto.domain.repository.ClienteRepository;

public class ConsultaClienteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext  = new SpringApplicationBuilder(XptoProjectApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		ClienteRepository  ClienteRepository  = applicationContext.getBean(ClienteRepository.class);
		
		List<Cliente> clientes = ClienteRepository.listar();
		
		for (Cliente cliente : clientes) {
			System.out.println("ID: " + cliente.getId() + " " +  "Nome: " + cliente.getNome() + " " + "Cidade: " + cliente.getCidade());
			
		}
	}
}
