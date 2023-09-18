package br.com.postechfiap.jlapp.dominio.adaptadores.services;

import br.com.postechfiap.jlapp.dominio.portas.interfaces.ClienteServicePort;
import br.com.postechfiap.jlapp.dominio.portas.repositories.ClienteRespositoryPort;

public class ClienteServiceImp implements ClienteServicePort{
	
	private final ClienteRespositoryPort clienteRespositoryPort;

    public ClienteServiceImp(ClienteRespositoryPort clienteRespositoryPort) {
        this.clienteRespositoryPort = clienteRespositoryPort;
    }

}
