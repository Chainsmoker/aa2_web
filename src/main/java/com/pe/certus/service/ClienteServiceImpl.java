package com.pe.certus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.certus.entity.Cliente;
import com.pe.certus.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente clienteId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void crearModificarCliente(Cliente cliente) {
		Cliente cli = new Cliente();
		cli.setId(cliente.getId());
		cli.setPaterno(cliente.getPaterno());
		cli.setMaterno(cliente.getMaterno());
		cli.setNombre(cliente.getNombre());
		cli.setDni(cliente.getDni());
		cli.setCiudad(cliente.getCiudad());
		cli.setCorreo(cliente.getCorreo());
		if(!cliente.isEstado()) {
			cli.setEstado(true);
		}else{
			cli.setEstado(cliente.isEstado());
		}
		clienteRepository.save(cli);
	}

	@Override
	public void eliminarCliente(Long id) {
		clienteRepository.deleteById(id);
	}

}
