package br.com.postechfiap.jlapp.infraestrutura.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.dominio.adaptadores.services.ClienteServiceImp;
import br.com.postechfiap.jlapp.dominio.portas.interfaces.ClienteServicePort;
import br.com.postechfiap.jlapp.dominio.portas.repositories.ClienteRespositoryPort;

@Configuration
public class BeanConfiguracao {

	@Bean
	ClienteServicePort clienteService(ClienteRespositoryPort clienteRespositoryPort) {
		return new ClienteServiceImp(clienteRespositoryPort);
	}
}
